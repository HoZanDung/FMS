package com.cms.controller;

import com.cms.service.Impl.UserServiceImpl;

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

    @Autowired
    UserServiceImpl userService;

    /**
     *
     * @param id
     * @return 单个用户信息
     */
    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET)
    public Map<String, Object> get(@PathVariable Long id) {
        return userService.findOne(id);
    }

    /**
     *
     * @param page
     * @param size
     * @return 分页查找所有用户信息
     */
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public Map index(@RequestParam(value = "page", defaultValue = "0") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return userService.index(page, size);
    }

    /**
     * 添加操作
     * @param request
     */
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public void create(HttpServletRequest request) {
        userService.create(request);
    }

    /**
     * 删除操作
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    /**
     * 恢复操作
     * @param id
     */
    @RequestMapping(value = "/recovery/{id}", method = RequestMethod.PUT)
    public void recovery(@PathVariable Long id) {
        userService.recovery(id);
    }

    /**
     * 更新操作
     * @param id
     * @param request
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, HttpServletRequest request) {
        userService.update(request, id);
    }

}
