package com.cms.service.Impl;

import com.cms.Presenter.UserPresenter;
import com.cms.entity.SysUser;

import com.cms.repository.SysUserRepository;
import com.cms.service.IUserService;

import org.springframework.stereotype.Service;

/**
 * Created by HOZANDUNG on 17/5/18.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<SysUser,SysUserRepository,UserPresenter> implements IUserService {

}
