package com.cms.service.Impl;

import com.cms.Presenter.UserPresenter;
import com.cms.entity.SysUser;

import com.cms.repository.SysUserRepository;
import com.cms.service.IUserService;

import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/18.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<SysUser,SysUserRepository,UserPresenter> implements IUserService {


    public Map<String, Object> myself(Principal principal) {
        try {
            return presenter.objectToMap(repository.findByUsername(principal.getName()));
        } catch (NullPointerException e) {
            System.out.println("请登录,异常没写");
            return null;
        }
    }
}
