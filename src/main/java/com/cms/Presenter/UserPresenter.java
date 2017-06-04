package com.cms.Presenter;

import com.cms.entity.SysRole;
import com.cms.entity.SysUser;
import com.cms.repository.SysRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by HOZANDUNG on 17/5/25.
 */
@Component
public class UserPresenter extends BasePresenter<SysUser> {

    @Autowired
    SysRoleRepository roleRepository;

    private String[] toCreate = {"username", "password", "email", "address", "phone", "avatar", "realname"};

    private String[] toUpdate = {"password", "email", "address", "phone", "avatar", "realname"};

    private String[] toFind = {"id" ,"username", "password" , "email", "address", "phone", "avatar", "realname","roles","status"};


    /**
     * 查找出来用户的属性
     * @param sysUser
     * @return
     */
    @Override
    public Map objectToMap(SysUser sysUser) {
        return transform(sysUser,toFind,true);
    }

    /**
     * 根据request生成实体对象
     * @param request
     * @return
     */
    @Override
    public SysUser toCreate(HttpServletRequest request) {
        SysUser user = mapToObject(new SysUser(), toCreate, request);
        grantUserDefaultRole(user);
        return user;
    }

    /**
     * 根据request生成实体对象
     * @param request
     * @param sysUser
     * @return
     */
    @Override
    public SysUser toUpdate(HttpServletRequest request, SysUser sysUser) {
        sysUser = mapToObject(sysUser, toUpdate, request);
        return sysUser;
    }


    /**
     * 给用户赋予USER权限
     * @param user
     */
    private void grantUserDefaultRole(SysUser user) {
        SysRole role = roleRepository.findOne(2L);
        List<SysRole> sysRoles = new LinkedList<>();
        sysRoles.add(role);
        user.setRoles(sysRoles);
    }
}
