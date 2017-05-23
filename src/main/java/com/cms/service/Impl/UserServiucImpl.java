package com.cms.service.Impl;

import com.cms.entity.SysRole;
import com.cms.entity.SysUser;

import com.cms.repository.SysRoleRepository;
import com.cms.repository.SysUserRepository;
import com.cms.service.IUserService;
import com.cms.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HOZANDUNG on 17/5/18.
 */
@Service
public class UserServiucImpl implements IUserService {

    @Autowired
    SysUserRepository userRepository;

    @Autowired
    SysRoleRepository roleRepository;

    @Override
    public void update(long id, HttpServletRequest request) {
        SysUser user = userRepository.findOne(id);
        user.setUsername(request.getParameterMap().get("name")[0]);
        user.setPassword(request.getParameterMap().get("password")[0]);
        SysRole role = roleRepository.findOne(Long.parseLong(request.getParameterMap().get("role_id")[0]));
        // 传入的role_id无效
        if(role == null) return;
        List<SysRole> sysRoles = new LinkedList<>();
        sysRoles.add(role);
        user.setRoles(sysRoles);
        userRepository.save(user);
    }

    @Override
    public void delete(long id) {
        userRepository.delete(id);
        userRepository.flush();

    }
}
