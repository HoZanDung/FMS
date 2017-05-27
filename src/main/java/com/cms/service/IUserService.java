package com.cms.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HOZANDUNG on 17/5/18.
 */
public interface IUserService {

    Map index(int page, int size);

    Map<String, Object> findOne(Long id);

    void create(HttpServletRequest request);

    void delete(Long id);

    void update(HttpServletRequest request, Long id);

    void destroy(Long id);

    void recovery(Long id);

}
