package dev.keyairen.ufcdashboard.data;

import dev.keyairen.ufcdashboard.model.Fight;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class FightDataProcessor implements ItemProcessor<FightInput, Fight> {

    private static final Logger log = LoggerFactory.getLogger(FightDataProcessor.class);

    @Override
    public Fight process(final FightInput fightInput) throws Exception {

        Fight fight = new Fight();
        fight.setId(Long.parseLong(fightInput.getId()));
        fight.setEventName(fightInput.getEventName());
        fight.setRedFighter(fightInput.getRedFighter());
        fight.setBlueFighter(fightInput.getBlueFighter());
        fight.setDate(LocalDate.parse(fightInput.getDate()));
        fight.setLocation(fightInput.getLocation());
        fight.setCountry(fightInput.getCountry());
        fight.setWinner(fightInput.getWinner());
        fight.setTitleBout(Boolean.parseBoolean(fightInput.getTitleBout()));
        fight.setWeightClass(fightInput.getWeightClass());
        fight.setGender(fightInput.getGender());
        fight.setNumberOfRounds(Integer.parseInt(fightInput.getNumberOfRounds()));
        fight.setBlueDraws(Integer.parseInt(fightInput.getBlueDraws()));
        fight.setBlueLosses(Integer.parseInt(fightInput.getBlueLosses()));
        fight.setBlueWins(Integer.parseInt(fightInput.getBlueWins()));
        fight.setBlueStance(fightInput.getBlueStance());
        fight.setBlueHeightCms(Double.parseDouble(fightInput.getBlueHeightCms()));
        fight.setBlueReachCms(Double.parseDouble(fightInput.getBlueReachCms()));
        fight.setBlueWeightLbs(Integer.parseInt(fightInput.getBlueWeightLbs()));
        fight.setRedDraws(Integer.parseInt(fightInput.getRedDraws()));
        fight.setRedLosses(Integer.parseInt(fightInput.getRedLosses()));
        fight.setRedWins(Integer.parseInt(fightInput.getRedWins()));
        fight.setRedStance(fightInput.getRedStance());
        fight.setRedHeightCms(Double.parseDouble(fightInput.getRedHeightCms()));
        fight.setRedReachCms(Double.parseDouble(fightInput.getRedReachCms()));
        fight.setRedWeightLbs(Integer.parseInt(fightInput.getRedWeightLbs()));
        fight.setRedAge(Integer.parseInt(fightInput.getRedAge()));
        fight.setBlueAge(Integer.parseInt(fightInput.getBlueAge()));
        fight.setFinishDetails(fightInput.getFinishDetails());

        return fight;
    }

}
