package com.cms.Presenter;

import com.cms.entity.StorageDetail;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class StorageDetailPresenter extends BasePresenter<StorageDetail> {

    @Override
    public StorageDetail toCreate(HttpServletRequest request) {
        return null;
    }

    @Override
    public StorageDetail toUpdate(HttpServletRequest request, StorageDetail storageDetail) {
        return null;
    }
}
