package com.cms.service.Impl;

import com.cms.Presenter.SupplierPresenter;
import com.cms.entity.Supplier;
import com.cms.repository.SupplierRepository;
import com.cms.service.ISupplierService;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceImpl extends BaseServiceImpl<Supplier, SupplierRepository, SupplierPresenter> implements ISupplierService {
}
