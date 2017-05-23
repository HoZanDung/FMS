package com.cms.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by HOZANDUNG on 17/5/7.
 */
public interface IFileService {


    public String upload(MultipartFile file, int userid, String author, int category, String content, String title);

    public String download();
}
