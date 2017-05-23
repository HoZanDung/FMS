package com.cms.service;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HOZANDUNG on 17/5/18.
 */
public interface IUserService {

    public void update(long id, HttpServletRequest request);

    public void delete(long id);

}
