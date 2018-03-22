package com.cms.service;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by HOZANDUNG on 18/3/5.
 */
public interface IDrugService {

    Map index(int page, int size);

    void create(HttpServletRequest request);

    void delete(Long id);

    void update(HttpServletRequest request, Long id);

    void destroy(Long id);

    void recovery(Long id);

    Map findBy(int page, int size, String name);

    Map findByAll(String name, String type, String introduce, String drugbar, String
            genericName, String pinyinCode, String retailPrice, String
                          replenishPrice, String unit, String dosage, String
                          origin, String validity, String qualityStandard, String
                          operation, String batchNumber, int page, int size);
}
