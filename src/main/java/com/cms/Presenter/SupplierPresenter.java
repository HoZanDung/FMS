package com.cms.Presenter;

import com.cms.entity.Supplier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class SupplierPresenter extends BasePresenter<Supplier> {

    @Override
    public Supplier toCreate(HttpServletRequest request) {
        return null;
    }

    @Override
    public Supplier toUpdate(HttpServletRequest request, Supplier supplier) {
        return null;
    }
}
