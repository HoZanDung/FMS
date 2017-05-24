package com.cms.Development;

import com.cms.entity.SysRole;
import com.cms.entity.SysUser;
import com.cms.repository.SysRoleRepository;
import com.cms.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HOZANDUNG on 17/5/24.
 */
@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    //
    boolean alreadySetup = false;
    @Autowired
    SysUserRepository userRepository;
    @Autowired
    SysRoleRepository roleRepository;


    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (alreadySetup) return;


        //Create Role
        SysRole sysRole_admin = new SysRole();
        sysRole_admin.setName("ROLE_ADMIN");
        sysRole_admin.setCreate_ip("0:0:0:0:0:0:0:1");
        sysRole_admin.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysRole_admin.setCreate_time(new Date());
        sysRole_admin.setUpdate_time(new Date());
        sysRole_admin.setDescription("管理员");
        roleRepository.save(sysRole_admin);

        SysRole sysRole_user = new SysRole();
        sysRole_user.setName("ROLE_USER");
        sysRole_user.setCreate_ip("0:0:0:0:0:0:0:1");
        sysRole_user.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysRole_user.setCreate_time(new Date());
        sysRole_user.setUpdate_time(new Date());
        sysRole_user.setDescription("用户");
        roleRepository.save(sysRole_user);


        //Create User
        SysUser sysUser_admin = new SysUser();
        SysRole role_admin = roleRepository.findOne(1L);
        List<SysRole> sysRoles_admin = new LinkedList<>();
        sysRoles_admin.add(role_admin);
        sysUser_admin.setUsername("root");
        sysUser_admin.setPassword("root");
        sysUser_admin.setCreate_ip("0:0:0:0:0:0:0:1");
        sysUser_admin.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysUser_admin.setCreate_time(new Date());
        sysUser_admin.setUpdate_time(new Date());
        sysUser_admin.setEmail("root@qq.com");
        sysUser_admin.setAddress("大学城校区3栋610");
        sysUser_admin.setPhone("13048034431");
        sysUser_admin.setRealname("何震东");
        sysUser_admin.setRoles(sysRoles_admin);
        userRepository.save(sysUser_admin);

        SysUser sysUser_user = new SysUser();
        SysRole role_user = roleRepository.findOne(2L);
        List<SysRole> sysRoles_user = new LinkedList<>();
        sysRoles_user.add(role_user);
        sysUser_user.setUsername("dong");
        sysUser_user.setPassword("dong");
        sysUser_user.setCreate_ip("0:0:0:0:0:0:0:1");
        sysUser_user.setUpdate_ip("0:0:0:0:0:0:0:1");
        sysUser_user.setCreate_time(new Date());
        sysUser_user.setUpdate_time(new Date());
        sysUser_user.setEmail("dong@qq.com");
        sysUser_user.setAddress("大学城校区3栋610");
        sysUser_user.setPhone("13048034432");
        sysUser_user.setRealname("何震东");
        sysUser_user.setRoles(sysRoles_user);
        userRepository.save(sysUser_user);

        alreadySetup = true;
    }
}
