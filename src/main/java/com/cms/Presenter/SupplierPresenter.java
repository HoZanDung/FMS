package com.cms.Presenter;

import com.cms.entity.Supplier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class SupplierPresenter extends BasePresenter<Supplier> {

    private String[] toCreate = {"name", "pinyinCode", "address",
            "area", "zipCode", "phone",
            "contactPerson", "bank", "bankAccount"};

    private String[] toUpdate = {"name", "pinyinCode", "address",
            "area", "zipCode", "phone",
            "contactPerson", "bank", "bankAccount"};

    private String[] toFind = {"id", "name", "pinyinCode", "address",
            "area", "zipCode", "phone", "contactPerson",
            "bank", "bankAccount", "status"};

    @Override
    public Map objectToMap(Supplier supplier) {
        return transform(supplier, toFind, true);
    }

    /**
     * 根据requset生成实体
     *
     * @param request
     * @return
     */
    @Override
    public Supplier toCreate(HttpServletRequest request) {
        Supplier supplier = mapToObject(new Supplier(), toCreate, request);
        return supplier;
    }

    /**
     * 根据request生成实体
     *
     * @param request
     * @param supplier
     * @return
     */
    @Override
    public Supplier toUpdate(HttpServletRequest request, Supplier supplier) {
        supplier = mapToObject(supplier, toUpdate, request);
        return supplier;
    }
}
