package com.cms.Presenter;

import com.cms.entity.StorageDetail;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class StorageDetailPresenter extends BasePresenter<StorageDetail> {

    private String[] toFind = {"id", "documentNo", "drugNumber", "storageAmount",
            "storageUnitPrice", "storageAllPrice", "storageDate",
            "storageAmounting", "storageStatus", "status"};

    private String[] toCreate = {"documentNo", "drugNumber", "storageAmount", "storageUnitPrice",
            "storageAllPrice", "storageDate", "storageAmounting", "storageStatus", "status"};

    private String[] toUpdate = {"documentNo", "drugNumber", "storageAmount", "storageUnitPrice",
            "storageAllPrice", "storageDate", "storageAmounting", "storageStatus"};

    @Override
    public Map objectToMap(StorageDetail storageDetail) {
        return transform(storageDetail, toFind, true);
    }

    /**
     * 根据request生成实体
     *
     * @param request
     * @return
     */
    @Override
    public StorageDetail toCreate(HttpServletRequest request) {
        StorageDetail storageDetail = mapToObject(new StorageDetail(), toCreate, request);
        return storageDetail;
    }

    /**
     * 根据request生成实体
     *
     * @param request
     * @param storageDetail
     * @return
     */
    @Override
    public StorageDetail toUpdate(HttpServletRequest request, StorageDetail storageDetail) {
        storageDetail = mapToObject(storageDetail, toUpdate, request);
        return storageDetail;
    }
}
