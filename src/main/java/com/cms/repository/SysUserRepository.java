package com.cms.repository;

import com.cms.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HOZANDUNG on 17/5/8.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);

}
