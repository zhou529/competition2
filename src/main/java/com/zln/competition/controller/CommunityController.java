package com.zln.competition.controller;

import com.zln.competition.bean.ComAdmin;
import com.zln.competition.bean.Community;
import com.zln.competition.bean.Team;
import com.zln.competition.service.ComAdminService;
import com.zln.competition.service.CommunityService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@ResponseBody
public class CommunityController {
    @Resource
    CommunityService communityService;
    @Resource
    ComAdminService comAdminService;


    /**
     * 根据社团名模糊查询
     */
    @RequestMapping(value = "/selectCommunityDim")
    public List<Community> selectCommunityDim(@RequestParam("inputVal") String inputVal){
        System.out.println("CommunityController的selectCommunityDim方法执行啦");
        Community community = new Community();
        community.setComName("%"+inputVal+"%");
        List<Community> communities = communityService.selectCommunityDim(community);
        return communities;
    }

    /**
     * 修改页面的属性值
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/getCommunityBySession", method = RequestMethod.POST)
    public Community getCommunityBySession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Community community = (Community) session.getAttribute("community");
//        ComAdmin admin = session.getAttribute("admin");
        System.out.println("community : " + community);
        return community;
    }

    @RequestMapping(value = "/putCommunity", method = RequestMethod.POST)
    public void putCommunityBySession(@RequestParam("comId") String comId,
                                      @RequestParam("comName") String comName,
                                      @RequestParam("comQq") String comQq,
                                      @RequestParam("comInformation") String comInformation,
                                      @RequestParam("comWin") String comWin,
                                      HttpServletRequest request) {
       /* Community community = communityService.selectCommunityByComId(comId);
        System.out.println("putCommunityBySession的community = " + community);
        //获取application对象
        HttpSession session = request.getSession();
        session.setAttribute("community",community);*/
        Community community = new Community();

        community.setComId(Integer.valueOf(comId));
        community.setComName(comName);
        community.setComQq(comQq);
        community.setComWin(comWin);
        community.setComInformation(comInformation);
        //获取application对象
        HttpSession session = request.getSession();
        session.setAttribute("community", community);
//        return community;
    }

    @Transactional
    @RequestMapping(value = "/updateByCommunity", method = RequestMethod.POST)
    public int updateByCommunity(@RequestParam("comName") String comName,
                                 @RequestParam("comQq") String comQq,
                                 @RequestParam("comInformation") String comInformation,
                                 @RequestParam("comWin") String comWin,
                                 HttpServletRequest request) {
        System.out.println("CommunityController的updateByCommunity方法执行啦");
        HttpSession session = request.getSession();
        Community community1 = (Community) session.getAttribute("community");
        Integer comId = community1.getComId();

        Community community = new Community();
        ComAdmin comAdmin = new ComAdmin();
        community.setComId(comId);
        community.setComName(comName);
        community.setComQq(comQq);
        community.setComInformation(comInformation);
        community.setComWin(comWin);

        System.out.println("ComName() = " +comName);
        System.out.println("community1.getComName() = " + community1.getComName());
        //如果没有对应的管理员信息直接添加即可
        ComAdmin isExistComAdmin = comAdminService.selectByComName(community1.getComName());
        if( isExistComAdmin==null){
            System.out.println("isExistComAdmin==null");
            int updateByCommunity = communityService.updateByCommunity(community);
            if (updateByCommunity != 0) {
                return 1;
            }
        }else {//如果有管理员，则需要修改com_admin的com_name
            System.out.println("============isExistComAdmin不是null============");
            if( comName != community1.getComName()){
                System.out.println("==================com_name 发生变化了============");
                community.setComName(comName);
                comAdmin.setComId(isExistComAdmin.getComId());
//                comAdmin.setComName(comName);
                comAdmin.setComName(comName);
                int updateByCommunity = communityService.updateByCommunity(community);
//            comAdmin.setComId(comId);
                if (updateByCommunity != 0) {
                    int updateByComAdmin = comAdminService.updateByComAdmin(comAdmin);
                    if (updateByComAdmin != 0) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    @RequestMapping(value = "/deleteByComId", method = RequestMethod.POST)
    public int deleteByComId(@RequestParam("comId") Integer comId) {
        int i1 = 0;
        System.out.println("CommunityController的deleteByComId方法执行啦");
        System.out.println("前台传过来的comUsername ： " + comId);
        int i = communityService.deleteByComId(comId);
        System.out.println("ComAdminController的deleteByComId方法的返回值i = " + i);
        return i;
    }


    /**
     * 添加功能
     *
     * @param comName
     * @param comQq
     * @param comInformation
     * @return
     */
    @RequestMapping(value = "/insertCommunity", method = RequestMethod.POST)
    public int insertCommunity(@RequestParam("comName") String comName,
                               @RequestParam("comQq") String comQq,
                               @RequestParam("comInformation") String comInformation,
                               @RequestParam("comWin") String comWin) {
        System.out.println("CommunityController的insertCommunity方法执行了");

        System.out.println("页面传过来的数据 : comName = " + comName);
        System.out.println("页面传过来的数据 : comQq = " + comQq);
        System.out.println("页面传过来的数据 : comInformation = " + comInformation);
        System.out.println("页面传过来的数据 : comWin = " + comWin);

        Community community = new Community();
        community.setComName(comName);
        community.setComQq(comQq);
        community.setComInformation(comInformation);
        community.setComWin(comWin);

        int insertCommunity = communityService.insertCommunity(community);
        System.out.println("CommunityController的insertCommunity方法的返回值insertCommunity = " + insertCommunity);
        return insertCommunity;
    }


    @RequestMapping(value = "/selectAllCommunity", method = RequestMethod.POST)
    public List<Community> selectAllCommunity(HttpServletRequest request) {
        List<Community> communities = communityService.selectAllCommunity();
        System.out.println("CommunityController的selectAllCommunity的返回值communities ： " + communities);
        return communities;
    }

    public List<Community> selectAllCommunity() {
        List<Community> communities = communityService.selectAllCommunity();
        return communities;
    }

    @RequestMapping(value = "/selectCommunityByComName", method = RequestMethod.POST)
    public List<Community> selectCommunityByComName(HttpServletRequest request) {
        System.out.println("CommunityController的selectCommunityByComId方法执行啦");
        List<Community> communities = null;
        //获取管理员权限
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println(" request.getSession();获取到的admin对象 ： " + admin.toString());
        Integer comIs = admin.getComIs();
        if (comIs == 2) {
            //只有超级管理员可以看
            communities = selectAllCommunity();
        }/*else {
            //获取comId
//            Integer comId = admin.getComId();
            String comName = admin.getComName();
            System.out.println("comId = " + comName);
            communities = selectCommunityByComName(comName);
            System.out.println("CommunityController的selectByComId的返回值communities ： " + communities);
        }*/
        return communities;
    }
    @RequestMapping(value = "/selectCommunityByComId")
    public Community selectCommunityByComId(@RequestParam("comId") String comId) {
        System.out.println("CommunityController的selectCommunityByComNameWx方法执行啦");
        Community community = communityService.selectCommunityByComId(Integer.valueOf(comId));
        System.out.println("community = " + community);
        return community;
    }


  /*  @RequestMapping(value = "/selectByComName", method = RequestMethod.POST)
    public Community selectByComName(@RequestParam("comName") String comName) {
        System.out.println("CommunityController的selectByComName方法执行了");
        Community community = communityService.selectCommunityByComName(comName);
        System.out.println("CommunityController的selectByComName的返回值community ： " + community);
        return community;
    }*/

    /**
     * 判断竞赛名称是否存在 and 根据comName查询功能
     *
     * @param comName
     * @return
     */
    @RequestMapping(value = "/isExistCommunity", method = RequestMethod.POST)
    public int isExistCommunity(@RequestParam("comName") String comName) {
        System.out.println("CommunityController的isExistCommunity方法执行了");
        Community community = communityService.selectCommunityByComName(comName);
        System.out.println("CommunityController的isExistCommunity方法的返回值community = " + community);
        //用户名不存在可以添加
        //1为不可用，0为可用
        if (community == null) {//用户名可用
            return 0;
        }
        //用户名不可用
        return 1;

    }

}
