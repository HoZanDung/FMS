package com.cms.repository;

import com.cms.entity.BaseModel;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by HOZANDUNG on 17/5/25.
 */
public interface BaseRepository<M extends BaseModel> extends PagingAndSortingRepository<M,Long> {
}
