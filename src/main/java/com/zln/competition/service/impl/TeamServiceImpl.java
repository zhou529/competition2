package com.zln.competition.service.impl;

import com.zln.competition.bean.Team;
import com.zln.competition.mapper.TeamMapper;
import com.zln.competition.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Resource
    TeamMapper teamMapper;

    @Override
    public Team selectTeamByTeamId(Integer teamId){
        Team team = teamMapper.selectTeamByTeamId(teamId);
        return team;
    }

    @Override
    public List<Team> selectTeamDim(Team DimTeam){
        List<Team> teams = teamMapper.selectTeamDim(DimTeam);
        return teams;
    }
    @Override
    public int updateTeamByTeamId(Team record){
        return teamMapper.updateTeamByTeamId(record);
    }

    @Override
    public List<Team> selectTeamByTeamName(String teamName) {
        List<Team> teams = teamMapper.selectTeamByTeamName(teamName);
        return teams;
    }

    @Override
    public int deleteByTeamId(Integer teamId) {
        return teamMapper.deleteByTeamId(teamId);
    }

    @Override
    public List<Team> selectTeamByComId(Integer comId) {
        List<Team> teams = teamMapper.selectTeamByComId(comId);
        return teams;
    }


    @Override
    public List<Team> selectAllTeam() {
        List<Team> teams = teamMapper.selectAllTeam();
        return teams;
    }

    @Override
    public List<Team> selectByUserId(Integer userId) {
        List<Team> teams = teamMapper.selectByUserId(userId);
        return teams;
    }

    @Override
    public int insertTeamInfo(Team team) {
        int i = teamMapper.insertTeamInfo(team);
        return i;
    }

}
