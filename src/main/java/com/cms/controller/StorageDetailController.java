package com.cms.controller;

import com.cms.service.IStorageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/StorageDetailController")
public class StorageDetailController {

    @Autowired
    private IStorageDetailService storageDetailService;

    /**
     * 分页查找药库存信息
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Map index(@RequestParam(value = "page", defaultValue = "0") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return storageDetailService.index(page, size);
    }

    /**
     * 添加一个药库存信息
     *
     * @param request
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(HttpServletRequest request) {
        storageDetailService.create(request);
    }

    /**
     * 删除一个药库存信息(逻辑删除)
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        storageDetailService.delete(id);
    }

    /**
     * 恢复操作(逻辑恢复)
     *
     * @param id
     */
    @RequestMapping(value = "/recovery/{id}", method = RequestMethod.PUT)
    public void recovery(@PathVariable Long id) {
        storageDetailService.recovery(id);
    }

    /**
     * 更新药库存信息
     *
     * @param id
     * @param request
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, HttpServletRequest request) {
        storageDetailService.update(request, id);
    }

    /**
     * 彻底删除
     *
     * @param id
     */
    @RequestMapping(value = "/destroy/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable Long id) {
        storageDetailService.destroy(id);
    }
}
