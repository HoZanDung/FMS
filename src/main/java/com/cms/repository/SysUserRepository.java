package com.cms.repository;

import com.cms.entity.SysUser;

/**
 * Created by HOZANDUNG on 17/5/8.
 */
public interface SysUserRepository extends BaseRepository<SysUser> {

    SysUser findByUsername(String username);

}
