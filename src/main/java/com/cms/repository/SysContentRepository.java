package com.cms.repository;

import com.cms.entity.SysContent;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by HOZANDUNG on 17/5/15.
 */
public interface SysContentRepository extends PagingAndSortingRepository<SysContent, Integer> {
    SysContent findByUserid(int userid);
}
