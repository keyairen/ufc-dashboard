package dev.keyairen.ufcdashboard.Repository;

import dev.keyairen.ufcdashboard.model.Fight;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FightRepository extends CrudRepository<Fight, Long> {

    List<Fight> getByRedFighterOrBlueFighterOrderByDateDesc(String redFighter, String blueFighter, Pageable pageable);

    default List<Fight> findLatestFightsByFighter(String fighterName, int count) {
        return getByRedFighterOrBlueFighterOrderByDateDesc(fighterName, fighterName, PageRequest.of(0, count));
    }
}
