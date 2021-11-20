package com.zln.competition.bean;

public class Team {
    private String teamName;

    private String teamQq;

    private String teamInformation;

    private String competitionName;

    private Integer teamId;

    private Integer comId;

    private Integer userId;

    public Team() {
    }
    public Team(String teamName, String teamQq, String teamInformation, String competitionName, Integer teamId, Integer comId, Integer userId) {
        this.teamName = teamName;
        this.teamQq = teamQq;
        this.teamInformation = teamInformation;
        this.competitionName = competitionName;
        this.teamId = teamId;
        this.comId = comId;
        this.userId = userId;
    }


    public String getTeamInformation() {
        return teamInformation;
    }

    public void setTeamInformation(String teamInformation) {
        this.teamInformation = teamInformation;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }





    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamQq() {
        return teamQq;
    }

    public void setTeamQq(String teamQq) {
        this.teamQq = teamQq;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", teamQq='" + teamQq + '\'' +
                ", teamInformation='" + teamInformation + '\'' +
                ", competitionName='" + competitionName + '\'' +
                ", teamId=" + teamId +
                ", comId=" + comId +
                ", userId=" + userId +
                '}';
    }

}
