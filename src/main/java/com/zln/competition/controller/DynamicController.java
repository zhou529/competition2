package com.zln.competition.controller;

//import com.alibaba.fastjson.JSONObject;
import com.zln.competition.bean.Dynamic;
import com.zln.competition.sensitive_word_filter.SensitivewordFilter;
import com.zln.competition.service.DynamicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
public class DynamicController {
    @Autowired
    DynamicService dynamicService;

    @RequestMapping(value = "/selectDynamicByDynId")
    public Dynamic selectDynamicByDynId(@RequestParam("dynId") String dynId) {
        System.out.println("DynamicController的selectDynamicByDynId方法执行了");
        Dynamic dynamic = dynamicService.selectDynamicByDynId(Integer.valueOf(dynId));
        return dynamic;
    }


    @RequestMapping(value = "/addDynamic")
    public int addDynamic(@RequestParam("dynamicInfo") String dynamicInfo,
                          @RequestParam("dynTitle") String dynTitle){
//                          @RequestParam("dateTime") String dateTime
        System.out.println("DynamicController的addDynamic方法执行了");
        //查找是否包含敏感词
        SensitivewordFilter sensitivewordFilter = new SensitivewordFilter();
        SensitivewordFilter filter = new SensitivewordFilter();
        System.out.println("敏感词的数量：" + sensitivewordFilter.sensitiveWordMap.size());
        System.out.println("待检测语句字数：" + dynamicInfo.length());
        long beginTime = System.currentTimeMillis();
        Set<String> set = filter.getSensitiveWord(dynamicInfo, 1);
        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime));
        //把敏感词汇替换成*
        String replaceDynamicInfo = sensitivewordFilter.replaceSensitiveWord(dynamicInfo, 1, "*");
        System.out.println("替换之后的语句：" + replaceDynamicInfo);
        //向数据库里面插入数据
        Dynamic dynamic = new Dynamic();
        dynamic.setDynInformation(dynamicInfo);
        dynamic.setDynTitle(dynTitle);
        int i = dynamicService.addDynamic(dynamic);
        return i;
    }



    private static final Logger logger = LoggerFactory.getLogger(DynamicController.class);

    @RequestMapping(value = "/selectAllDynamic", method = RequestMethod.POST)
    public List<Dynamic> selectAllDynamic() {
        System.out.println("DynamicController的selectAllDynamic方法执行了");
        List<Dynamic> dynamics = dynamicService.selectAllDynamic();
        System.out.println("DynamicController的selectAllDynamic方法的返回值dynamics ： " + dynamics);
        return dynamics;
    }

    //获取当前日期时间的string类型用于文件名防重复
    public String dates() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateDtring = formatter.format(currentTime);
        return dateDtring;
    }

    /*@RequestMapping(value = "/addDynamic")
    public void addDynamic(HttpServletRequest request, String dynTitle, String dynInformation, String dynImg1, String dynImg2) {
        System.out.println("dynTitle : " + dynTitle);
        System.out.println("dynInformation : " + dynInformation);
        System.out.println("dynImg1 : " + dynImg1);
        System.out.println("dynImg2 : " + dynImg2);
        //获取从前台传过来的图片
        MultipartHttpServletRequest req = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = req.getFile("file");
        //获取图片的文件类型
        String contentType = multipartFile.getContentType();
        int one = contentType.lastIndexOf("/");

        System.out.println(contentType.substring((one + 1), contentType.length()));
        System.out.println(multipartFile.getName());
        //根据获取到的文件类型截取出图片后缀
        String type = contentType.substring((one + 1), contentType.length());
        System.out.println(multipartFile.getContentType());

        String filename;
        String realPath = request.getRealPath("/upload/wximg/");
        try {
            File dir = new File(realPath);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //获取到当前的日期时间用户生成文件名防止文件名重复
            String filedata = this.dates();
            //生成一个随机数来防止文件名重复
            int x = (int) (Math.random() * 1000);
            filename = "zhongshang" + x + filedata;
            System.out.println(x);
//            将文件的地址和生成的文件名拼在一起
            File file = new File(realPath, filename + "." + type);
            multipartFile.transferTo(file);
            //将图片在项目中的地址和isok状态储存为json格式返回给前台，由于公司项目中没有fastjson只能用这个
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("isok", 1);
//            jsonObject.put("dizhi", "/upload/wximg/" + filename + "." + type);
//
//            writer.write(jsonObject.toString());
        } catch (IOException | IllegalStateException e) {
            e.printStackTrace();
        }
    }*/

    /*@RequestMapping(value = "/addDynamic")
    public String addDynamic(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filePath = "";
        request.setCharacterEncoding("utf-8"); //设置编码
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        File dir = new File(realPath);
        //文件目录不存在，就创建一个
        if (!dir.isDirectory()) {
            dir.mkdirs();
        }
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            //获取formdata的值
            Iterator<String> iterator = req.getFileNames();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String timedata = request.getParameter("timedata");

            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                String fileName = file.getOriginalFilename();
                //真正写到磁盘上
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String kzm = fileName.substring(fileName.lastIndexOf("."));
                String filename = uuid + kzm;
                File file1 = new File(realPath + filename);
                OutputStream out = new FileOutputStream(file1);
                out.write(file.getBytes());
                out.close();
                filePath = request.getScheme() + "://" +
                        request.getServerName() + ":"
                        + request.getServerPort()
                        + "/uploadFile/" + filename;
                System.out.println("访问图片路径:" + filePath + "====username:" + username);
            }
        } catch (Exception e) {
            logger.error("", e);
        }
        return filePath;
    }*/
}
