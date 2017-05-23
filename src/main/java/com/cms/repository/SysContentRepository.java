package com.cms.repository;

import com.cms.entity.SysContent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by HOZANDUNG on 17/5/15.
 */
public interface SysContentRepository extends JpaRepository<SysContent, Integer> {
    SysContent findByUserid(int userid);
}
