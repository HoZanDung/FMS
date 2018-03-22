package com.cms.service.Impl;

import com.cms.Presenter.DrugPresenter;
import com.cms.entity.SysDrug;
import com.cms.repository.SysDrugRepository;
import com.cms.service.IDrugService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by HOZANDUNG on 18/3/5.
 */
@Service
public class DrugServiceImpl extends BaseServiceImpl<SysDrug, SysDrugRepository, DrugPresenter> implements IDrugService {

    @Override
    public Map findBy(int page, int size, String name) {
        return presenter.packPages(repository.findAllByNameContaining(name, new PageRequest(page, size)));
    }

    @Override
    public Map findByAll(String name, String type, String introduce, String drugbar, String genericName, String pinyinCode, String retailPrice, String replenishPrice, String unit, String dosage, String origin, String validity, String qualityStandard, String operation, String batchNumber, int page, int size) {
        return presenter.packPages(repository.findAllByNameContainingAndTypeContainingAndBatchNumberContainingAndIntroduceContainingAndDrugbarContainingAndGenericNameContainingAndPinyinCodeContainingAndRetailPriceContainingAndReplenishPriceContainingAndUnitContainingAndDosageContainingAndValidityContainingAndQualityStandardContainingAndOperationContainingAndBatchNumberContaining(
                name, type, introduce, drugbar,
                genericName, pinyinCode, retailPrice,
                replenishPrice, unit, dosage,
                origin, validity, qualityStandard,
                operation, batchNumber, new PageRequest(page, size)));
    }
}
