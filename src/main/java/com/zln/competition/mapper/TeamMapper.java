package com.zln.competition.mapper;

import com.zln.competition.bean.Team;

import java.util.List;

public interface TeamMapper {
    public List<Team> selectAllTeam();

    public List<Team> selectByUserId(Integer userId);

    public int insertTeamInfo(Team team);

    public List<Team> selectTeamByComId(Integer comId);

    List<Team> selectTeamByTeamName(String teamName);

    List<Team> selectTeamByLikeCompetitionName(String competitionName);

    int deleteByTeamId(Integer teamId);

    int updateTeamByTeamId(Team record);

    List<Team> selectTeamDim(Team DimTeam);

    Team selectTeamByTeamId(Integer teamId);
}
