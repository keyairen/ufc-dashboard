package dev.keyairen.ufcdashboard.Repository;

import dev.keyairen.ufcdashboard.model.Fight;
import org.springframework.cglib.core.Local;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FightRepository extends CrudRepository<Fight, Long> {

    List<Fight> getByRedFighterOrBlueFighterOrderByDateDesc(String redFighter, String blueFighter, Pageable pageable);

    @Query(
            "select f from Fight f where (f.redFighter = :fighterName or f.blueFighter = :fighterName)"
                    + " and f.date between :dateStart and :dateEnd order by f.date desc")
    List<Fight> getFightsByFighterBetweenDates(
            @Param("fighterName") String fighterName,
            @Param("dateStart") LocalDate dateStart,
            @Param("dateEnd") LocalDate dateEnd);

    default List<Fight> findLatestFightsByFighter(String fighterName, int count) {
        return getByRedFighterOrBlueFighterOrderByDateDesc(fighterName, fighterName, PageRequest.of(0, count));
    }
}
