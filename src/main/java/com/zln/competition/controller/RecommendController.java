package com.zln.competition.controller;

import com.zln.competition.bean.*;
import com.zln.competition.service.ComAdminService;
import com.zln.competition.service.RecommendService;
import com.zln.competition.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ResponseBody
public class RecommendController {
    @Autowired
    RecommendService recommendService;
    @Autowired
    UserInfoService userInfoService;

    @RequestMapping(value = "/selectRecommendByLikeRecname",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public List<Recommend> selectRecommendByLikeRecname(@RequestParam("recName") String recName) throws UnsupportedEncodingException {
        System.out.println("RecommendController的selectRecommendByLikeRecname方法执行啦");
        System.out.println("recName = " + recName);
        String decode = URLDecoder.decode(recName, "utf-8");
        System.out.println("decode = " + decode);

        Recommend recommend = new Recommend();
        recommend.setRecName("%"+decode+"%");
        List<Recommend> recommends = recommendService.selectRecommendDim(recommend);
        return recommends;
    }


    @RequestMapping(value = "/updateRecImg",method = RequestMethod.POST)
    public Map<String, Object> updateRecImg(@RequestParam MultipartFile fileExcel,
                                            @RequestParam("recId") String recId){
        System.out.println("recId = " + recId);
        ImageUpLoad imageUpLoad = new ImageUpLoad();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> stringObjectMap = imageUpLoad.imgExport(fileExcel);
        Boolean result = (Boolean) stringObjectMap.get("result");
        System.out.println("stringObjectMap.get(\"result\") = " + stringObjectMap.get("result"));
        if(result){
            String fileName = fileExcel.getOriginalFilename();
            System.out.println("fileName = " + fileName);
            Recommend recommend = new Recommend();
            recommend.setRecId(Integer.valueOf(recId));
            recommend.setRecImg(fileName);
            int is_update= recommendService.updateRecImgByRecId(recommend);
            if(is_update != 0){
                return stringObjectMap;
            }
        }
        map.put("result",true);
        map.put("errorMsg","参数错误！");
        return map;
    }


    @RequestMapping(value = "/selectByTag")
    public List<Recommend> selectByTag(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        Users user = (Users) servletContext.getAttribute("user");
        String userOpenid = user.getUserOpenid();
        System.out.println("拉拉拉拉拉拉啊啦啦user = " + user);
        System.out.println("拉拉拉拉拉拉啊啦啦user = " + userOpenid);
        System.out.println("selectByTag");

        // 判断是否实名认证过
        UserInfo userInfo = userInfoService.selectByOpenId(userOpenid);
        System.out.println("userInfoService.selectByOpenId(userOpenid); = " + userInfo);
        System.out.println("userInfo.getUserMajor() = " + userInfo.getUserMajor());

        List<Recommend> recommends;
        if(userInfo.getUserMajor() == null || userInfo.getUserMajor() == ""){
            recommends = recommendService.selectAllRecommend();
            System.out.println("recommends : " + recommends);
            return recommends;
        }else {
            recommends = recommendService.selectByTag(userOpenid);
            System.out.println("controller的selectByTag方法的返回值 ：" + recommends);
        }
        return recommends;
    }

    @RequestMapping(value = "/recommend_number_for_community")
    public List<Recommend> recommend_number_for_community() {
        List<Recommend> recommends = recommendService.recommend_number_for_community();
        return recommends;
    }



    @RequestMapping(value = "/hot_category")
    public List<Recommend> hot_category() {
        List<Recommend> recommends = recommendService.hot_category();
        return recommends;
    }

    @RequestMapping(value = "/recommend_race")
    public List<Recommend> recommend_race() {
        List<Recommend> recommends = recommendService.recommend_race();
        return recommends;
    }


    @RequestMapping(value = "/updateRecommendBrowseByRecIdWX")
    public int updateRecommendBrowseByRecIdWX(@RequestParam("recId") String recId){
        System.out.println("RecommendController的updateRecommendBrowseByRecIdWX方法执行啦");
        int i = recommendService.updateRecommendBrowseByRecIdWX(Integer.valueOf(recId));
        return i;
    }


    @RequestMapping(value = "/selectRecommendDim")
    public List<Recommend> selectRecommendDim(@RequestParam("inputVal") String inputVal){
        System.out.println("RecommendController的selectRecommendDim方法执行啦");
        Recommend recommend = new Recommend();
        recommend.setRecName("%"+inputVal+"%");
        List<Recommend> recommends = recommendService.selectRecommendDim(recommend);
        return recommends;
    }


    @RequestMapping(value = "/updateRecommendByRecId", method = RequestMethod.POST)
    public int updateRecommendByRecId(HttpServletRequest request,
                                      @RequestParam("recName") String recName,
                                      @RequestParam("recBegintime") String recBegintime,
                                      @RequestParam("recEndtime") String recEndtime,
                                      @RequestParam("recOrganizer") String recOrganizer,
                                      @RequestParam("recInformation") String recInformation){
        System.out.println("RecommendController的updateRecommendByRecId执行啦");
        HttpSession session = request.getSession();
        Recommend recommendBySession = (Recommend) session.getAttribute("recommend");
        Integer recId = recommendBySession.getRecId();

        Recommend recommend = new Recommend();
        recommend.setRecId(recId);
        recommend.setRecName(recName);
        recommend.setRecBegintime(recBegintime);
        recommend.setRecEndtime(recEndtime);
        recommend.setRecOrganizer(recOrganizer);
        recommend.setRecInformation(recInformation);
        System.out.println("updateRecommendByRecId的commend" + recommend);
        int i = recommendService.updateRecommendByRecId(recommend);
        return i;
    }

    @RequestMapping(value = "/getRecommend", method = RequestMethod.POST)
    public Recommend getRecommend(HttpServletRequest request) {
        System.out.println("RecommendController的getRecommend执行啦");
        HttpSession session = request.getSession();
        Recommend recommend = (Recommend) session.getAttribute("recommend");
//        ComAdmin admin = session.getAttribute("admin");
        System.out.println("recommend : " + recommend.toString());
        return recommend;
    }

    @RequestMapping(value = "/putRecommend", method = RequestMethod.POST)
    public void putRecommend(@RequestParam("recId") String recId,
                            @RequestParam("recName") String recName,
                            @RequestParam("recInformation") String recInformation,
                            @RequestParam("recBegintime") String recBegintime,
                            @RequestParam("recEndtime") String recEndtime,
                            @RequestParam("recOrganizer") String recOrganizer,
                            HttpServletRequest request) {
        System.out.println("RecommendController的putRecommend执行啦");
        Recommend recommend = new Recommend();
        recommend.setRecId(Integer.valueOf(recId));
        recommend.setRecName(recName);
        recommend.setRecInformation(recInformation);
        recommend.setRecBegintime(recBegintime);
        recommend.setRecEndtime(recEndtime);
        recommend.setRecOrganizer(recOrganizer);

        //获取application对象
        HttpSession session = request.getSession();
        session.setAttribute("recommend", recommend);
//        return community;
    }
    /*public List<Recommend> selectRecommendByComId(HttpServletRequest request){
        System.out.println("RecommendController的selectRecommendByComId方法被调用啦~~~~~~");
        //获取到管理员对象
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("admin");
        System.out.println("获取到的admin对象 ： " + admin.toString());
        //通过admin获取到com_id
        Integer comId = admin.getComId();
        //通过Recommend获取竞赛信息
        List<Recommend> recommends = recommendService.selectRecommendByComId(comId);
        System.out.println("获取到的recommends是 ： " + recommends);

        //把获取到的信息存放在session中，以便前台使用
        ServletContext servletContext = request.getServletContext();
        servletContext.setAttribute("recommends",recommends);

        return recommends;

    }*/

    /**
     * 根据recId删除
     * @param recId
     * @return 1：删除成功
     */
    @RequestMapping("/deleteByRecId")
    public int deleteByRecId(@RequestParam("recId") Integer recId){
        //        int i1 = 0;
        System.out.println("RecommendController的deleteByRecId方法执行啦");
        System.out.println("前台传过来的recId ： " + recId);
        int i = recommendService.deleteByRecId(recId);
        System.out.println("RecommendController的deleteByRecId方法的返回值i = " + i);
        return i;
    }

    @RequestMapping("/allDeleteRecommend")
    public int allDeleteRecommend(){
        //        int i1 = 0;
        System.out.println("RecommendController的allDeleteRecommend方法执行啦");
//        int i = recommendService.allDeleteRecommend();
//        System.out.println("RecommendController的allDeleteRecommend方法的返回值i = " + i);
//        return i;
        return 1;
    }


    @RequestMapping(value = "/selectAllRecommendByAdmin",method = RequestMethod.POST)
    public List<Recommend> selectAllRecommendByAdmin(HttpServletRequest request){
        List<Recommend> recommends;
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println(" request.getSession();获取到的admin对象 ： " + admin.toString());
        //判断是否是管理员
        Integer comIs = admin.getComIs();
        if(comIs == 2){
            //是管理员，显示全部竞赛信息
            recommends = selectAllRecommend();
        }else {
            //不是管理员，要通过comId获取
            //通过admin获取到com_id
            Integer comId = admin.getComId();
            recommends = selectRecommendByComId(comId);

        }
        //把获取到的信息存放在session中，以便前台使用
        ServletContext application = request.getServletContext();
        application.setAttribute("recommends",recommends);
        return recommends;
    }

    public List<Recommend> selectRecommendByComId(Integer comId){
        //通过Recommend获取竞赛信息
        List<Recommend> recommends = recommendService.selectRecommendByComId(comId);
        System.out.println("获取到的recommends是 ： " + recommends);
        return recommends;

    }

    public List<Recommend> selectAllRecommend() {
        List<Recommend> recommends = recommendService.selectAllRecommend();
        System.out.println("recommends : " + recommends);
        return recommends;
    }
    @RequestMapping(value = "/selectAllRecommend",method = RequestMethod.POST)
    public List<Recommend> selectAllRecommend(HttpServletRequest request){
        ServletContext servletContext = request.getServletContext();
        List<Recommend> recommends = recommendService.selectAllRecommend();
        servletContext.setAttribute("recommends",recommends);
        System.out.println("recommends : " + recommends);
        return recommends;
    }

    @RequestMapping(value = "/selectRecommendAndCommunityByRecName")
    public Recommend selectRecommendAndCommunityByRecName(String recName){
        System.out.println("Controller类的selectRecommendAndCommunityByRecName方法执行了");
        System.out.println("接手过来的参数recName ： " + recName);
        Recommend recommend = recommendService.selectRecommendAndCommunityByRecName(recName);
        System.out.println("recommend : " + recommend);
        return recommend;
    }


    @RequestMapping(value = "/selectRecommendById")
    public Recommend selectRecommendById(@RequestParam("recId") String recId){
        System.out.println("Controller类的selectRecommendById方法执行了");
        System.out.println("前台传过来的值id = " + recId);
        Recommend recommend =recommendService.selectRecommendById(Integer.parseInt(recId));
        System.out.println("controller的selectRecommendById方法的返回值 ：" + recommend);
        return recommend;
    }

    /**
     * 添加竞赛信息前的验证
     * @param recName
     * @return
     */
    @RequestMapping(value = "/selectRecommendByRecName",method = RequestMethod.POST)
    public List<Recommend> selectRecommendByRecName(@RequestParam("recName") String recName){
        System.out.println("Controller类的selectRecommendByRecName方法执行了");
        System.out.println("前台接收的recName = " + recName);
        List<Recommend> recommends = recommendService.selectRecommendByRecName(recName);
        System.out.println("Controller类的selectRecommendByRecName方法查询到的recommends="+recommends);
        return recommends;
    }

    @RequestMapping(value = "/insertRecommend",method = RequestMethod.POST)
    public int insertRecommend(@RequestParam("recName") String recName,
                               @RequestParam("recBegintime") String recBegintime,
                               @RequestParam("recEndtime") String recEndtime,
                               @RequestParam("recOrganizer") String recOrganizer,
                               @RequestParam("recInformation") String recInformation,
                               HttpServletRequest request){
        System.out.println("Controller类的insertRecommend方法执行了");

        //获取comId
        HttpSession session = request.getSession();
        ComAdmin admin = (ComAdmin) session.getAttribute("loginAdmin");
        System.out.println(" request.getSession();获取到的admin对象 ： " + admin.toString());
        //判断是否是管理员
        Integer comId = admin.getComId();

        //传入值
        Recommend recommend = new Recommend();
        recommend.setRecName(recName);
        recommend.setRecBegintime(recBegintime);
        recommend.setRecEndtime(recEndtime);
        recommend.setRecOrganizer(recOrganizer);
        recommend.setRecInformation(recInformation);
        recommend.setComId(comId);

        //调用service层，插入语事局
        int i = recommendService.insertRecommend(recommend);

        return i;
    }
}
