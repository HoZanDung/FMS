package com.cms.service.Impl;

import com.cms.Presenter.StorageMainPresenter;
import com.cms.entity.StorageMain;
import com.cms.repository.StorageMainRepository;
import com.cms.service.IStorageMainService;
import org.springframework.stereotype.Service;

@Service
public class StorageMainServiceImpl extends BaseServiceImpl<StorageMain,StorageMainRepository,StorageMainPresenter> implements IStorageMainService {
}
