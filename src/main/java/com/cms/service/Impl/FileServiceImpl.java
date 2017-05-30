package com.cms.service.Impl;

import com.cms.Presenter.FilePresenter;
import com.cms.entity.SysContent;
import com.cms.entity.SysUser;
import com.cms.repository.SysContentRepository;
import com.cms.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;


/**
 * Created by HOZANDUNG on 17/5/8.
 */
@Service
public class FileServiceImpl extends BaseServiceImpl<SysContent,SysContentRepository,FilePresenter>  implements IFileService {

    @Value("${upload.file.path}")
    private String filePath;

    @Autowired FilePresenter presenter;


    @Override
    public Map upload(MultipartFile file, HttpServletRequest request) {
        //实例化neientity
        SysContent sysContent = new SysContent();
        //判断文件是否为空
        if (file.isEmpty()) {
            System.out.println("文件为空");
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
            //上传后将信息录入数据库
            SysContent content = presenter.toCreate(request);
            content.setFile_path(filePath+fileName);
            presenter.setCreateInfo(request,content);
            save(request,content);
        } catch (IllegalStateException e) {
            System.out.println("异常,还没写");
        } catch (IOException e) {
            System.out.println("异常,还没写");
        }
        return null;
    }

    @Override
    public String download() {
        return null;
    }
}
