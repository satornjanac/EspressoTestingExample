package com.arm.satornjanac.esspressotestsexamples;

import java.util.ArrayList;

/**
 * Created by satornjanac on 5/6/15.
 */
public class ChangeTeamRequest {

    private String name;
    private String surname;
    private String currentTeam;
    private String newTeam;
    private String technology;
    private String level;
    private boolean isMan;
    private boolean isWoman;

    public static ArrayList<ChangeTeamRequest> requests = new ArrayList<>();

    public ChangeTeamRequest(String name, String surname, String currentTeam, String newTeam,
                             String technology, String level, boolean isMan, boolean isWoman) {
        this.name = name;
        this.surname = surname;
        this.currentTeam = currentTeam;
        this.newTeam = newTeam;
        this.technology = technology;
        this.level = level;
        this.isMan = isMan;
        this.isWoman = isWoman;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCurrentTeam() {
        return currentTeam;
    }

    public String getNewTeam() {
        return newTeam;
    }

    public String getTechnology() {
        return technology;
    }

    public String getLevel() {
        return level;
    }

    public boolean isMan() {
        return isMan;
    }

    public boolean isWoman() {
        return isWoman;
    }
}
