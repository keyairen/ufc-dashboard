package dev.keyairen.ufcdashboard.data;

import dev.keyairen.ufcdashboard.model.Fighter;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JobCompletionNotificationListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);

    private final EntityManager em;

    @Autowired
    public JobCompletionNotificationListener(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("!!! JOB FINISHED! Time to verify the results");

            Map<String, Fighter> fighterData = new HashMap<>();

            em.createQuery("SELECT f.fighter, SUM(f.totalFights), SUM(f.totalWins), SUM(f.totalLosses) "
                            + "FROM ("
                            + "    SELECT f.redFighter AS fighter, COUNT(*) AS totalFights, "
                            + "           COUNT(CASE WHEN f.winner = 'Red' THEN 1 ELSE NULL END) AS totalWins, "
                            + "           COUNT(CASE WHEN f.winner = 'Blue' THEN 1 ELSE NULL END) AS totalLosses "
                            + "    FROM Fight f GROUP BY f.redFighter "
                            + "    UNION ALL "
                            + "    SELECT f.blueFighter AS fighter, COUNT(*) AS totalFights, "
                            + "           COUNT(CASE WHEN f.winner = 'Blue' THEN 1 ELSE NULL END) AS totalWins, "
                            + "           COUNT(CASE WHEN f.winner = 'Red' THEN 1 ELSE NULL END) AS totalLosses "
                            + "    FROM Fight f GROUP BY f.blueFighter"
                            + ") f "
                            + "GROUP BY f.fighter", Object[].class)
                    .getResultList()
                    .stream()
                    .map(e -> new Fighter((String) e[0], (long) e[1], (long) e[2], (long) e[3]))
                    .forEach(fighter -> fighterData.put(fighter.getFighterName(), fighter));

            fighterData.values().forEach(em::persist);
            fighterData.values().forEach(System.out::println);
            System.out.println("FIGHTER SIZE: " + fighterData.size());
        }
    }
}