package com.cms.controller;

import com.cms.service.Impl.UserServiucImpl;
import com.cms.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/15.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired UserServiucImpl userServiuc;

    @Autowired MapUtil mapUtil;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(HttpServletRequest request) {
        userServiuc.add(request);
        return "调用了update,POST方法,插入操作";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Long id,HttpServletRequest request) {
        userServiuc.update(id,request);
        return "调用了update,PUT方法,更新操作";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        userServiuc.delete(id);
        return "update,DELETE方法,删除操作";
    }


}
