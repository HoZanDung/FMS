package com.cms.service.Impl;

import com.cms.Presenter.StorageDetailPresenter;
import com.cms.entity.StorageDetail;
import com.cms.repository.StorageDetailRepository;
import com.cms.service.IStorageDetailService;
import org.springframework.stereotype.Service;

@Service
public class StorageDetailServiceImpl extends BaseServiceImpl<StorageDetail, StorageDetailRepository, StorageDetailPresenter> implements IStorageDetailService {
}
