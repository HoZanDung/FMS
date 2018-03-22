package com.cms.Presenter;

import com.cms.entity.StorageMain;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class StorageMainPresenter extends BasePresenter<StorageMain> {

    @Override
    public StorageMain toCreate(HttpServletRequest request) {
        return null;
    }

    @Override
    public StorageMain toUpdate(HttpServletRequest request, StorageMain storageMain) {
        return null;
    }
}
