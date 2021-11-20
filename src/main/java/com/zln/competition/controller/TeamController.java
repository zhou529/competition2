package com.zln.competition.controller;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.Team;
import com.zln.competition.bean.User;
import com.zln.competition.bean.UserInfo;
import com.zln.competition.service.TeamService;
import com.zln.competition.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@ResponseBody
public class TeamController {
    @Autowired
    TeamService teamService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/selectTeamByTeamId")
    public Team selectTeamByTeamId(@RequestParam("teamId") String teamId){
        System.out.println("TeamController的selectTeamByTeamId执行啦");
        Team team = teamService.selectTeamByTeamId(Integer.valueOf(teamId));
        return team;
    }


    @RequestMapping(value = "/selectTeamDim")
    public List<Team> selectTeamDim(@RequestParam("inputVal") String inputVal){
        System.out.println("TeamController的selectTeamDim执行啦");
        System.out.println("inputVal = " + inputVal);
        Team team = new Team();
        team.setCompetitionName("%"+inputVal+"%");
        team.setTeamName("%"+inputVal+"%");
        List<Team> teams = teamService.selectTeamDim(team);
        return teams;
    }


    @RequestMapping(value = "/updateTeamByTeamId", method = RequestMethod.POST)
    public int updateTeamByTeamId(@RequestParam("teamName") String teamName,
                                  @RequestParam("teamQq") String teamQq,
                                  @RequestParam("competitionName") String competitionName,
                                  @RequestParam("teamInformation") String teamInformation,
                                  HttpServletRequest request){
        System.out.println("TeamController的updateTeamByTeamId执行啦");
        HttpSession session = request.getSession();
        Team teamBySession = (Team) session.getAttribute("team");
        Integer teamId = teamBySession.getTeamId();

        Team team = new Team();
        team.setTeamQq(teamQq);
        team.setTeamId(teamId);
        team.setTeamName(teamName);
        team.setTeamInformation(teamInformation);
        team.setCompetitionName(competitionName);

        int i = teamService.updateTeamByTeamId(team);
        return i;
    }


    @RequestMapping(value = "/getTeam", method = RequestMethod.POST)
    public Team getTeam(HttpServletRequest request) {
        System.out.println("TeamController的getTeam执行啦");
        HttpSession session = request.getSession();
        Team team = (Team) session.getAttribute("team");
//        ComAdmin admin = session.getAttribute("admin");
        System.out.println("team : " + team.toString());
        return team;
    }


    @RequestMapping(value = "/putTeam", method = RequestMethod.POST)
    public void putTeam(@RequestParam("teamId") String teamId,
                            @RequestParam("teamName") String teamName,
                            @RequestParam("teamInformation") String teamInformation,
                            @RequestParam("competitionName") String competitionName,
                            @RequestParam("teamQq") String teamQq,
                            HttpServletRequest request) {
        System.out.println("TeamController的putTeam执行啦");
        Team team = new Team();
        team.setTeamId(Integer.valueOf(teamId));
        team.setTeamName(teamName);
        team.setTeamInformation(teamInformation);
        team.setCompetitionName(competitionName);
        team.setTeamQq(teamQq);

        //获取application对象
        HttpSession session = request.getSession();
        session.setAttribute("team", team);
//        return community;
    }


    @RequestMapping(value = "/insertTeamInfo", method = RequestMethod.POST)
    public int insertTeamInfo(@RequestParam("teamName") String teamName,
                              @RequestParam("competitionName") String competitionName,
                              @RequestParam("teamQq") String teamQq,
                              @RequestParam("teamInformation") String teamInformation,
                              HttpServletRequest request){

        //获取comId
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println(" request.getSession();获取到的admin对象 ： " + admin.toString());
        Integer comId = admin.getComId();

        Team team = new Team();
        team.setTeamName(teamName);
        team.setCompetitionName(competitionName);
        team.setTeamQq(teamQq);
        team.setTeamInformation(teamInformation);
        team.setComId(comId);

        int i = teamService.insertTeamInfo(team);
        return i;
    }

    @RequestMapping(value = "/selectTeamByTeamName", method = RequestMethod.POST)
    public List<Team> selectTeamByTeamName(@RequestParam("teamName") String teamName) {
        System.out.println("TeamController的dselectTeamByTeamName方法执行啦");
        List<Team> teams = teamService.selectTeamByTeamName(teamName);
        return teams;
    }

    @RequestMapping(value = "/deleteByTeamId", method = RequestMethod.POST)
    public int deleteByTeamId(@RequestParam("teamId") Integer teamId) {
        System.out.println("TeamController的deleteByTeamId方法执行啦");
        System.out.println("前台传过来的teamId ： " + teamId);
        int i = teamService.deleteByTeamId(teamId);
        System.out.println("TeamController的deleteByTeamId方法的返回值i = " + i);
        return i;
    }


    //    int userId;
    @RequestMapping(value = "/selectTeamByComId", method = RequestMethod.POST)
    public List<Team> selectTeamByComId(HttpServletRequest request) {
        System.out.println("TeamController的selectTeamByComId方法执行啦");
        List<Team> teams = null;
        //获取管理员权限
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println(" request.getSession();获取到的admin对象 ： " + admin.toString());
        if (admin.getComIs() == 2) {
            teams = selectAllTeam();
        } else {
            //获取comId
            Integer comId = admin.getComId();
            teams = selectTeamByComId(comId);
        }
        return teams;
    }

    public List<Team> selectTeamByComId(Integer comId) {
        List<Team> teams = teamService.selectTeamByComId(comId);
        return teams;
    }

    public List<Team> selectAllTeam() {
        List<Team> teams = teamService.selectAllTeam();
        System.out.println("teams : " + teams);
        return teams;
    }
    @RequestMapping(value = "/selectAllTeamWx", method = RequestMethod.POST)
    public List<Team> selectAllTeamWx() {
        System.out.println("TeamController的selectAllTeamWx执行了");
        List<Team> teams = teamService.selectAllTeam();
        System.out.println("teams : " + teams);
        return teams;
    }

    @RequestMapping(value = "/selectByUserId", method = RequestMethod.POST)
    public List<Team> selectByUserId(HttpServletRequest request) {
        System.out.println("TeamController的selectByUserId执行了");
        ServletContext servletContext = request.getServletContext();
        User user1 = (User) servletContext.getAttribute("user");
        System.out.println("user1 : " + user1);
        String openid = user1.getUserOpenid();
        System.out.println("UserController获取到的openId-------------request.getAttribute(\"openid\") ：  " + openid);
        User user = userService.selectByOpenId(openid);
        int userId;
        if (user != null) {
            userId = user.getUserId();
            System.out.println(":userId : " + userId);
            List<Team> teams = teamService.selectByUserId(userId);
            if (teams != null) {
                System.out.println("selectByUserId 的teams ： " + teams);
                return teams;
            }
        }
        return null;
    }

    /*@RequestMapping(value = "/insertTeamInfo",method = RequestMethod.POST)
    public int insertTeamInfo(Team team){

    }*/
}
