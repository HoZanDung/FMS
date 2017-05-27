package com.cms.service.Impl;

import com.cms.Presenter.UserPresenter;
import com.cms.Validation.UserValidation;
import com.cms.entity.SysRole;
import com.cms.entity.SysUser;

import com.cms.repository.SysRoleRepository;
import com.cms.repository.SysUserRepository;
import com.cms.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HOZANDUNG on 17/5/18.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<SysUser,SysUserRepository,UserPresenter> implements IUserService {

}
