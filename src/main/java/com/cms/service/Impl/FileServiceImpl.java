package com.cms.service.Impl;

import com.cms.entity.SysContent;
import com.cms.entity.SysUser;
import com.cms.repository.SysContentRepository;
import com.cms.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * Created by HOZANDUNG on 17/5/8.
 */
@Service
public class FileServiceImpl implements IFileService {

    @Value("${upload.file.path}")
    private String filePath;

    @Autowired
    private SysContentRepository contentRepository;


    @Override
    public String upload(MultipartFile file, int userid, String author, int category, String content, String title) {
        //实例化neientity
        SysContent sysContent = new SysContent();
        //判断文件是否为空
        if (file.isEmpty()) {
            return "文件为空";
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //获取文件类型
        String filetype = file.getContentType();
        //获取文件大小
        long size = file.getSize();
        // 解决中文问题，liunx下中文路径，图片显示问题
        fileName = UUID.randomUUID() + suffixName;

        File dest = new File(filePath + fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            //上传
            file.transferTo(dest);
            //获取当前时间
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String today = sdf.format(d);
            //上传后将信息录入数据库并输出上传成功的时间
            sysContent.setUserid(userid);
            sysContent.setAuthor(author);
            sysContent.setCategory(category);
            sysContent.setContent(content);
            sysContent.setTitle(title);
            sysContent.setTime(today);
            sysContent.setFile_path(fileName);
            contentRepository.save(sysContent);
            return today + "-" + fileName + "-" + "上传成功";
        } catch (IllegalStateException e) {
            return "文件过大,内存溢出异常";
        } catch (IOException e) {
            return "文件路径错误,IO异常";
        }
    }

    @Override
    public String download() {
        return null;
    }
}
