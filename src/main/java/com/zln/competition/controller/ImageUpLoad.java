package com.zln.competition.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.DateUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ImageUpLoad {

    public Map<String, Object> imgExport( MultipartFile fileExcel) {
        System.out.println("fileExcel = " + fileExcel);
        Map<String, Object> map = new HashMap<>();
        InputStream is = null;
        try {
            is =  fileExcel.getInputStream();
            // 文件全称
            String fileName = fileExcel.getOriginalFilename();
            int index;
            byte[] bytes = new byte[1024];
            // 保存到本地地址,需要拼接上fileName，不然会报错
            String destinationWx = "F:\\myMIni\\images\\uploadImage\\"+fileName;
            FileOutputStream downloadFileWx = new FileOutputStream(destinationWx);
            String destinationJava = "F:\\myMIni\\images\\uploadImage\\"+fileName;
            FileOutputStream downloadFile = new FileOutputStream(destinationJava);
            while ((index = is.read(bytes)) != -1) {
                downloadFileWx.write(bytes, 0, index);
                downloadFileWx.flush();
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            downloadFileWx.close();
            downloadFile.close();
            is.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            map.put("result",false);
            map.put("errorMsg","文件格式有误！");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result",false);
            map.put("errorMsg","导入失败！");
            return map;
        }

        map.put("result",true);
        map.put("errorMsg","参数错误！");
        return map;
    }

    /*@RequestMapping(value = "/imageUpload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> excelImport(@RequestParam MultipartFile fileExcel,
                                           @RequestParam("productId") String productId) {
        System.out.println("fileExcel = " + fileExcel);
        System.out.println("productId = " + productId);
        Map<String, Object> map = new HashMap<>();
        InputStream is = null;
        try {
            is =  fileExcel.getInputStream();
            // 文件全称
            String fileName = fileExcel.getOriginalFilename();
            int index;
            byte[] bytes = new byte[1024];
            // 保存到本地地址,需要拼接上fileName，不然会报错
            String destinationWx = "F:\\myMIni\\images\\uploadImage\\"+fileName;
            FileOutputStream downloadFileWx = new FileOutputStream(destinationWx);
            String destinationJava = "F:\\myMIni\\images\\uploadImage\\"+fileName;
            FileOutputStream downloadFile = new FileOutputStream(destinationJava);
            while ((index = is.read(bytes)) != -1) {
                downloadFileWx.write(bytes, 0, index);
                downloadFileWx.flush();
                downloadFile.write(bytes, 0, index);
                downloadFile.flush();
            }
            downloadFileWx.close();
            downloadFile.close();
            is.close();
        } catch (IOException e1) {
            e1.printStackTrace();
            map.put("result",false);
            map.put("errorMsg","文件格式有误！");
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("result",false);
            map.put("errorMsg","导入失败！");
            return map;
        }

        map.put("result",true);
        map.put("errorMsg","参数错误！");
        System.out.println("map = " + map);
        System.out.println("map.keySet()" + map.keySet());
        System.out.println("map.values()" + map.values());
        return map;
    }
*/
}

