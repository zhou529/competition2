package com.zln.competition.service;

import com.zln.competition.bean.Team;

import java.util.List;

public interface TeamService {
    public List<Team> selectAllTeam();

    public List<Team> selectByUserId(Integer userId);

    public int insertTeamInfo(Team team);

    public List<Team> selectTeamByComId(Integer comId);

    int deleteByTeamId(Integer teamId);

    List<Team> selectTeamByTeamName(String teamName);

    public int updateTeamByTeamId(Team record);

    List<Team> selectTeamByLikeCompetitionName(String competitionName);

    List<Team> selectTeamDim(Team DimTeam);

    Team selectTeamByTeamId(Integer teamId);
}
