package com.cms.repository;

import com.cms.entity.StorageDetail;

public interface StorageDetailRepository extends BaseRepository<StorageDetail> {

    StorageDetail findByDrugNumber(String drugNumber);
}
