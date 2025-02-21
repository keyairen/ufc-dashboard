package dev.keyairen.ufcdashboard.Controller;

import dev.keyairen.ufcdashboard.Repository.FightRepository;
import dev.keyairen.ufcdashboard.Repository.FighterRepository;
import dev.keyairen.ufcdashboard.model.Fight;
import dev.keyairen.ufcdashboard.model.Fighter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
public class FighterController {

    private final FighterRepository fighterRepository;
    private final FightRepository fightRepository;

    public FighterController(FighterRepository fighterRepository, FightRepository fightRepository) {
        this.fighterRepository = fighterRepository;
        this.fightRepository = fightRepository;
    }

    @GetMapping("/fighter/{fighterName}")
    public Fighter getFighter(@PathVariable String fighterName) {
        Fighter fighter = this.fighterRepository.findByFighterName(fighterName);
        fighter.setFights(fightRepository.findLatestFightsByFighter(fighterName, 4));
        return fighter;
    }

    @GetMapping("/fighter/{fighterName}/fights")
    public List<Fight> getFightsForFighter(@PathVariable String fighterName, @RequestParam int year) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = LocalDate.of(year + 1, 1, 1);
        return this.fightRepository.getFightsByFighterBetweenDates(
                fighterName,
                startDate,
                endDate
        );
    }

}
