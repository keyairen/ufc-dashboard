package dev.keyairen.ufcdashboard.Controller;

import dev.keyairen.ufcdashboard.Repository.FightRepository;
import dev.keyairen.ufcdashboard.Repository.FighterRepository;
import dev.keyairen.ufcdashboard.model.Fighter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FighterController {

    private FighterRepository fighterRepository;
    private FightRepository fightRepository;

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

    @GetMapping("/health-check")
    public String getHealthCheck() {
        return "Situation Normal All Fired Up!";
    }

}
