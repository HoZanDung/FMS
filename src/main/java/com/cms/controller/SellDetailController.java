package com.cms.controller;

import com.cms.service.ISellDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/sellDetailController")
public class SellDetailController {

    @Autowired
    private ISellDetailService sellDetailService;

    /**
     * 分页查找销售单信息
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Map index(@RequestParam(value = "page", defaultValue = "1") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size) {
        page = page - 1;
        return sellDetailService.index(page, size);
    }

    /**
     * 添加一个销售单信息
     *
     * @param request
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(HttpServletRequest request) {
        sellDetailService.create(request);
    }

    /**
     * 删除一个销售单信息(逻辑删除)
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sellDetailService.delete(id);
    }

    /**
     * 恢复操作(逻辑恢复)
     *
     * @param id
     */
    @RequestMapping(value = "/recovery/{id}", method = RequestMethod.PUT)
    public void recovery(@PathVariable Long id) {
        sellDetailService.recovery(id);
    }

    /**
     * 更新销售单信息
     *
     * @param id
     * @param request
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, HttpServletRequest request) {
        sellDetailService.update(request, id);
    }

    /**
     * 彻底删除
     *
     * @param id
     */
    @RequestMapping(value = "/destroy/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable Long id) {
        sellDetailService.destroy(id);
    }
}
