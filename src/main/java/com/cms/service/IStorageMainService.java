package com.cms.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IStorageMainService {

    Map index(int page, int size);

    void create(HttpServletRequest request);

    void delete(Long id);

    void update(HttpServletRequest request, Long id);

    void destroy(Long id);

    void recovery(Long id);
}
