package dev.keyairen.ufcdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Fight {

    @Id
    private Long id;
    private String eventName;
    private String redFighter;
    private String blueFighter;
    private LocalDate date;
    private String location;
    private String country;
    private String winner;
    private Boolean titleBout;
    private String weightClass;
    private String gender;
    private int numberOfRounds;
    private int blueDraws;
    private int blueLosses;
    private int blueWins;
    private String blueStance;
    private Double blueHeightCms;
    private Double blueReachCms;
    private int blueWeightLbs;
    private int redDraws;
    private int redLosses;
    private int redWins;
    private String redStance;
    private Double redHeightCms;
    private Double redReachCms;
    private int redWeightLbs;
    private int redAge;
    private int blueAge;
    private String finish;
    private String finishDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getRedFighter() {
        return redFighter;
    }

    public void setRedFighter(String redFighter) {
        this.redFighter = redFighter;
    }

    public String getBlueFighter() {
        return blueFighter;
    }

    public void setBlueFighter(String blueFighter) {
        this.blueFighter = blueFighter;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public Boolean getTitleBout() {
        return titleBout;
    }

    public void setTitleBout(Boolean titleBout) {
        this.titleBout = titleBout;
    }

    public String getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(String weightClass) {
        this.weightClass = weightClass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public void setNumberOfRounds(int numberOfRounds) {
        this.numberOfRounds = numberOfRounds;
    }

    public int getBlueDraws() {
        return blueDraws;
    }

    public void setBlueDraws(int blueDraws) {
        this.blueDraws = blueDraws;
    }

    public int getBlueLosses() {
        return blueLosses;
    }

    public void setBlueLosses(int blueLosses) {
        this.blueLosses = blueLosses;
    }

    public int getBlueWins() {
        return blueWins;
    }

    public void setBlueWins(int blueWins) {
        this.blueWins = blueWins;
    }

    public String getBlueStance() {
        return blueStance;
    }

    public void setBlueStance(String blueStance) {
        this.blueStance = blueStance;
    }

    public Double getBlueHeightCms() {
        return blueHeightCms;
    }

    public void setBlueHeightCms(Double blueHeightCms) {
        this.blueHeightCms = blueHeightCms;
    }

    public Double getBlueReachCms() {
        return blueReachCms;
    }

    public void setBlueReachCms(Double blueReachCms) {
        this.blueReachCms = blueReachCms;
    }

    public int getBlueWeightLbs() {
        return blueWeightLbs;
    }

    public void setBlueWeightLbs(int blueWeightLbs) {
        this.blueWeightLbs = blueWeightLbs;
    }

    public int getRedDraws() {
        return redDraws;
    }

    public void setRedDraws(int redDraws) {
        this.redDraws = redDraws;
    }

    public int getRedLosses() {
        return redLosses;
    }

    public void setRedLosses(int redLosses) {
        this.redLosses = redLosses;
    }

    public int getRedWins() {
        return redWins;
    }

    public void setRedWins(int redWins) {
        this.redWins = redWins;
    }

    public String getRedStance() {
        return redStance;
    }

    public void setRedStance(String redStance) {
        this.redStance = redStance;
    }

    public Double getRedHeightCms() {
        return redHeightCms;
    }

    public void setRedHeightCms(Double redHeightCms) {
        this.redHeightCms = redHeightCms;
    }

    public Double getRedReachCms() {
        return redReachCms;
    }

    public void setRedReachCms(Double redReachCms) {
        this.redReachCms = redReachCms;
    }

    public int getRedWeightLbs() {
        return redWeightLbs;
    }

    public void setRedWeightLbs(int redWeightLbs) {
        this.redWeightLbs = redWeightLbs;
    }

    public int getRedAge() {
        return redAge;
    }

    public void setRedAge(int redAge) {
        this.redAge = redAge;
    }

    public int getBlueAge() {
        return blueAge;
    }

    public void setBlueAge(int blueAge) {
        this.blueAge = blueAge;
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public String getFinishDetails() {
        return finishDetails;
    }

    public void setFinishDetails(String finishDetails) {
        this.finishDetails = finishDetails;
    }
}
