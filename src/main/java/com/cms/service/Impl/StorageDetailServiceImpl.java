package com.cms.service.Impl;

import com.cms.Presenter.StorageDetailPresenter;
import com.cms.entity.StorageDetail;
import com.cms.entity.SysDrug;
import com.cms.repository.StorageDetailRepository;
import com.cms.repository.SysDrugRepository;
import com.cms.service.IStorageDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class StorageDetailServiceImpl extends BaseServiceImpl<StorageDetail, StorageDetailRepository, StorageDetailPresenter> implements IStorageDetailService {

    @Resource
    private SysDrugRepository drugRepository;

    @Override
    public void createDrug(HttpServletRequest request) {
        StorageDetail storageDetail = presenter.toCreate(request);
        Long drugNumber = Long.parseLong(storageDetail.getDrugNumber());
        SysDrug sysDrug = drugRepository.findOne(drugNumber);
        int storageAmount = Integer.parseInt(storageDetail.getStorageAmount());
        int storageNumber = Integer.parseInt(sysDrug.getStorageNumber());
        sysDrug.setStorageNumber(String.valueOf(storageAmount + storageNumber));
        drugRepository.save(sysDrug);
        presenter.setCreateInfo(request, storageDetail);
        validator(storageDetail);
        save(request, storageDetail);
    }
}
