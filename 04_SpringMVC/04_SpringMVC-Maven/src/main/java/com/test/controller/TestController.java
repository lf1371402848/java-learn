package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description: TODO
 * @Author: lf
 * @Date: 2022/8/22 19:05
 * @Version: 1.0
 */

@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "index";
    }

    @RequestMapping("/index")
    public String test1(){
        return "index";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(String username, MultipartFile filePic) throws
            IOException {
        System.out.println(username);
        // 获取文件名
        String originalFilename = filePic.getOriginalFilename();
        //保存文件
        filePic.transferTo(new File("D:/Desktop/"+originalFilename));
        return "success";
    }
}
