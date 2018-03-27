package com.cms.Presenter;

import com.cms.entity.SellDetail;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class SellDetailPresenter extends BasePresenter<SellDetail> {

    private String[] toFind = {"id", "sellNo", "drugNumber", "sellCredentials",
            "sellNumber", "sellPrice", "sellDate", "refundStatus", "status"};

    private String[] toCreate = {"sellNo", "drugNumber", "sellCredentials",
            "sellNumber", "sellPrice", "sellDate", "refundStatus"};

    private String[] toUpdate = {"sellNo", "drugNumber", "sellCredentials",
            "sellNumber", "sellPrice", "sellDate", "refundStatus"};

    @Override
    public Map objectToMap(SellDetail sellDetail) {
        return transform(sellDetail, toFind, true);
    }

    /**
     * 根据request生成实体
     *
     * @param request
     * @return
     */
    @Override
    public SellDetail toCreate(HttpServletRequest request) {
        SellDetail sellDetail = mapToObject(new SellDetail(), toCreate, request);
        return sellDetail;
    }

    /**
     * 根据request生成实体
     *
     * @param request
     * @param sellDetail
     * @return
     */
    @Override
    public SellDetail toUpdate(HttpServletRequest request, SellDetail sellDetail) {
        sellDetail = mapToObject(sellDetail, toUpdate, request);
        return sellDetail;
    }
}
