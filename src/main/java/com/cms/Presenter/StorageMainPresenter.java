package com.cms.Presenter;

import com.cms.entity.StorageMain;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class StorageMainPresenter extends BasePresenter<StorageMain> {

    private String[] toCreate = {"speciesAmount", "storageAmount", "storageAllPrice",
            "storageDate", "storageStatus", "transactor",
            "supplierNo"};

    private String[] toUpdate = {"speciesAmount", "storageAmount", "storageAllPrice",
            "storageDate", "storageStatus", "transactor",
            "supplierNo"};

    private String[] toFind = {"id", "status", "speciesAmount",
            "storageAmount", "storageAllPrice", "storageDate",
            "storageStatus", "transactor", "supplierNo"};

    @Override
    public Map objectToMap(StorageMain storageMain) {
        return transform(storageMain, toFind, true);
    }

    /**
     * 根据requset生成实体
     *
     * @param request
     * @return
     */
    @Override
    public StorageMain toCreate(HttpServletRequest request) {
        StorageMain storageMain = mapToObject(new StorageMain(), toCreate, request);
        return storageMain;
    }

    /**
     * 根据requset生成实体
     *
     * @param request
     * @return
     */
    @Override
    public StorageMain toUpdate(HttpServletRequest request, StorageMain storageMain) {
        storageMain = mapToObject(storageMain, toUpdate, request);
        return storageMain;
    }
}
