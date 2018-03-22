package com.cms.controller;

import com.cms.entity.SysDrug;
import com.cms.repository.SysDrugRepository;
import com.cms.service.IDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/drug")
public class DrugController {

    @Autowired
    private IDrugService drugService;
    @Resource
    private SysDrugRepository drugRepository;

    /**
     * 分页查找药品信息
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
        return drugService.index(page, size);
    }


    /**
     * 添加一个药品信息
     *
     * @param request
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void create(HttpServletRequest request) {
        drugService.create(request);
    }

    /**
     * 删除一个药品信息(逻辑删除)
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        drugService.delete(id);
    }

    /**
     * 恢复操作(逻辑恢复)
     *
     * @param id
     */
    @RequestMapping(value = "/recovery/{id}", method = RequestMethod.PUT)
    public void recovery(@PathVariable Long id) {
        drugService.recovery(id);
    }

    /**
     * 更新药品信息
     *
     * @param id
     * @param request
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void update(@PathVariable Long id, HttpServletRequest request) {
        drugService.update(request, id);
    }

    /**
     * 彻底删除
     *
     * @param id
     */
    @RequestMapping(value = "/destroy/{id}", method = RequestMethod.DELETE)
    public void destroy(@PathVariable Long id) {
        drugService.destroy(id);
    }

    /**
     * 模糊查询
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/findby", method = RequestMethod.POST)
    public Map findby(@RequestParam(value = "page", defaultValue = "1") int page,
                      @RequestParam(value = "size", defaultValue = "10") int size,
                      @RequestParam(value = "name", required = false) String name) {
        return drugService.findBy(page, size, name);
    }

    /**
     * 全字段模糊查询
     * @param name
     * @param type
     * @param introduce
     * @param drugbar
     * @param genericName
     * @param pinyinCode
     * @param retailPrice
     * @param replenishPrice
     * @param unit
     * @param dosage
     * @param origin
     * @param validity
     * @param qualityStandard
     * @param operation
     * @param batchNumber
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/findTest", method = RequestMethod.POST)
    public Map findTest(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "type", required = false) String type,
                        @RequestParam(value = "introduce", required = false) String introduce,
                        @RequestParam(value = "drugbar", required = false) String drugbar,
                        @RequestParam(value = "genericName", required = false) String genericName,
                        @RequestParam(value = "pinyinCode", required = false) String pinyinCode,
                        @RequestParam(value = "retailPrice", required = false) String retailPrice,
                        @RequestParam(value = "replenishPrice", required = false) String replenishPrice,
                        @RequestParam(value = "unit", required = false) String unit,
                        @RequestParam(value = "dosage", required = false) String dosage,
                        @RequestParam(value = "origin", required = false) String origin,
                        @RequestParam(value = "validity", required = false) String validity,
                        @RequestParam(value = "qualityStandard", required = false) String qualityStandard,
                        @RequestParam(value = "operation", required = false) String operation,
                        @RequestParam(value = "batchNumber", required = false) String batchNumber,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "size", defaultValue = "10") int size) {
        page = page - 1;
        return drugService.findByAll(name, type, introduce, drugbar, genericName, pinyinCode, retailPrice, replenishPrice, unit, dosage, origin, validity, qualityStandard, operation, batchNumber, page, size);
    }

}
