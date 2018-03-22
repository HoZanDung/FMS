package com.cms.controller;

import com.cms.service.IStorageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/storageMainController")
public class StorageMainController {

    @Autowired
    private IStorageDetailService storageDetailService;

    /**
     * 分页查找种类药品进仓信息
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Map index(@RequestParam(value = "page", defaultValue = "0") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size) {
        return storageDetailService.index(page, size);
    }

    /**
     * 添加一类药品进仓库
     *
     * @param request
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(HttpServletRequest request) {
        storageDetailService.create(request);
    }

    /**
     * 删除一个类药品信息(逻辑删除)
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
     * 更新类药品信息
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
