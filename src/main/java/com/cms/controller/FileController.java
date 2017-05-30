package com.cms.controller;

import com.cms.service.Impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/6.
 */
@RestController
@RequestMapping(value = "file")
public class FileController {

    @Autowired private FileServiceImpl fileService;

    /**
     *
     * @param page
     * @param size
     * @return 分页查找所有内容信息
     */
    @RequestMapping(method = RequestMethod.GET)
    public Map index(@RequestParam(value = "page", defaultValue = "0") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return fileService.index(page, size);
    }


    /**
     *
     * @param id
     * @return 单个内容信息
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Map findOne(@PathVariable Long id) {
        return fileService.findOne(id);
    }


    /**
     * 添加内容,文件上传
     * @param file
     * @param request
     * @return
     */
    //文件上传相关代码
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map upload(@RequestParam("file") MultipartFile file,
                         HttpServletRequest request) {
        return fileService.upload(file,request);
    }

    /**
     * 删除操作
     * @param id
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) { fileService.delete(id); }

    /**
     * 恢复操作
     * @param id
     */
    @RequestMapping(value = "/recovery/{id}", method = RequestMethod.PUT)
    public void recovery(@PathVariable Long id) {
        fileService.recovery(id);
    }


    /**
     * 更新操作
     * @param id
     * @param request
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, HttpServletRequest request) {
        fileService.update(request, id);
    }


}
