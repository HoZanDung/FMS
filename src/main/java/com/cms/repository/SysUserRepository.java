package com.cms.repository;

import com.cms.entity.SysUser;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by HOZANDUNG on 17/5/8.
 */
public interface SysUserRepository extends PagingAndSortingRepository<SysUser, Long> {

    SysUser findByUsername(String username);

}
