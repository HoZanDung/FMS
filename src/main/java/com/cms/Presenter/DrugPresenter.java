package com.cms.Presenter;

import com.cms.entity.SysDrug;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class DrugPresenter extends BasePresenter<SysDrug> {

    private String[] toCreate = {"name", "type", "introduce", "drugbar",
            "genericName", "pinyinCode", "retailPrice", "replenishPrice",
            "unit", "dosage", "origin", "validity",
            "qualityStandard", "operation", "batchNumber"};

    private String[] toUpdate = {"name", "type", "introduce", "drugbar",
            "genericName", "pinyinCode", "retailPrice", "replenishPrice",
            "unit", "dosage", "origin", "validity",
            "qualityStandard", "operation", "batchNumber"};

    private String[] toFind = {"id", "name", "type", "introduce", "drugbar",
            "genericName", "pinyinCode", "retailPrice", "replenishPrice",
            "unit", "dosage", "origin", "validity",
            "qualityStandard", "operation", "batchNumber", "status"};

    @Override
    public Map objectToMap(SysDrug sysDrug) {
        return transform(sysDrug, toFind, true);
    }

    @Override
    public SysDrug toCreate(HttpServletRequest request) {
        SysDrug sysDrug = mapToObject(new SysDrug(), toCreate, request);
        return sysDrug;
    }

    @Override
    public SysDrug toUpdate(HttpServletRequest request, SysDrug sysDrug) {
        sysDrug = mapToObject(sysDrug, toUpdate, request);
        return sysDrug;
    }
}
