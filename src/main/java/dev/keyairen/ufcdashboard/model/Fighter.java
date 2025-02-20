package dev.keyairen.ufcdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fighter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fighterName;
    private Long totalFights;
    private Long totalWins;
    private Long totalLosses;
    private Long totalDraws;

    public Fighter(String fighterName, Long totalFights, Long totalWins, Long totalLosses) {
        this.fighterName = fighterName;
        this.totalFights = totalFights;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
    }

    public Fighter() {

    }

    @Override
    public String toString() {
        return "Fighter{" +
                "totalLosses=" + totalLosses +
                ", totalWins=" + totalWins +
                ", totalFights=" + totalFights +
                ", fighterName='" + fighterName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFighterName() {
        return fighterName;
    }

    public void setFighterName(String fighterName) {
        this.fighterName = fighterName;
    }

    public Long getTotalFights() {
        return totalFights;
    }

    public void setTotalFights(Long totalFights) {
        this.totalFights = totalFights;
    }

    public Long getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(Long totalWins) {
        this.totalWins = totalWins;
    }

    public Long getTotalLosses() {
        return totalLosses;
    }

    public void setTotalLosses(Long totalLosses) {
        this.totalLosses = totalLosses;
    }

    public Long getTotalDraws() {
        return totalDraws;
    }

    public void setTotalDraws(Long totalDraws) {
        this.totalDraws = totalDraws;
    }
}
