package com.cms.controller;

import com.cms.repository.SysUserRepository;
import com.cms.service.Impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

/**
 * Created by HOZANDUNG on 17/5/6.
 */
@RestController
public class FileController {

    @Autowired private FileServiceImpl fs;

    @Autowired private SysUserRepository userRepository;

    //文件上传相关代码
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String upload(@RequestParam("test") MultipartFile file,
                         @RequestParam("category") int category,
                         @RequestParam("content") String content,
                         @RequestParam("title") String title, Principal principal) {

        long user_id_temp = userRepository.findByUsername(principal.getName()).getId();
        int userid = new Long(user_id_temp).intValue();
        String author = principal.getName();
        String result = fs.upload(file,userid,author,category,content,title);

        return result;
    }

}
