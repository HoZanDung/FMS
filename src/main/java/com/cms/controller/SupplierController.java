package com.cms.controller;

import com.cms.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private ISupplierService supplierService;

    /**
     * 分页查找供应商信息
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Map index(@RequestParam(value = "page", defaultValue = "1") int page,
                     @RequestParam(value = "size", defaultValue = "10") int size) {
        page = page - 1;
        return supplierService.index(page, size);
    }

    /**
     * 添加供应商
     *
     * @param request
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(HttpServletRequest request) {
        supplierService.create(request);
    }

    /**
     * 删除供应商信息(逻辑删除)
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        supplierService.delete(id);
    }

    /**
     * 恢复操作(逻辑恢复)
     *
     * @param id
     */
    @RequestMapping(value = "/recovery/{id}", method = RequestMethod.PUT)
    public void recovery(@PathVariable Long id) {
        supplierService.recovery(id);
    }

    /**
     * 更新供应商信息
     *
     * @param id
     * @param request
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, HttpServletRequest request) {
        supplierService.update(request, id);
    }

    /**
     * 彻底删除
     *
     * @param id
     */
    @RequestMapping(value = "/destroy/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable Long id) {
        supplierService.destroy(id);
    }

}
