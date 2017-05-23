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

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String update(@PathVariable Long id,HttpServletRequest request) {
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        String test = parameterMap.get("test")[0];
//        System.out.println();
//        System.out.println(parameterMap.get("test2"));


//        Map resMap = mapUtil.transToMAP(request.getParameterMap());
//        String aaa = resMap.get("test").toString();
//        System.out.println(aaa);
//        System.out.println("--------------------------------------------------------");

//        userServiuc.update(id,request);
//       String[] list = request.getParameterMap().get("test");
//        for (int i = 0; i <list.length ; i++) {
//            System.out.println(list[i]);
//        }
        userServiuc.update(id,request);
        return "调用了update,PUT方法,更新操作";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
        userServiuc.delete(id);
        return "update,DELETE方法,删除操作";
    }


}
