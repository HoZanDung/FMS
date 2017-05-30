package com.cms.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/7.
 */
public interface IFileService {


    public Map upload(MultipartFile file, HttpServletRequest request);

    public String download();
}
