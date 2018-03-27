package com.cms.service.Impl;

import com.cms.Presenter.SellDetailPresenter;
import com.cms.entity.SellDetail;
import com.cms.entity.StorageDetail;
import com.cms.repository.SellDetailRepository;
import com.cms.repository.StorageDetailRepository;
import com.cms.service.ISellDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class SellDetailServiceImpl extends BaseServiceImpl<SellDetail, SellDetailRepository, SellDetailPresenter> implements ISellDetailService {

    @Resource
    private StorageDetailRepository storageDetailRepository;

    /**
     * 重写创建方法实现业务关联
     *
     * @param request
     */
    @Override
    public String createByString(HttpServletRequest request) {
        SellDetail m = presenter.toCreate(request);
        presenter.setCreateInfo(request, m);
        validator(m);
        //得到药品编号
        String drugNumber = m.getDrugNumber();
        //得到销售数量
        String sellNumber = m.getSellNumber();
        int sellNumber_int = Integer.parseInt(sellNumber);
        //根据药品编号找出相应的库存信息
        StorageDetail storageDetail = storageDetailRepository.findByDrugNumber(drugNumber);
        if (storageDetail == null || storageDetail.equals("")){
            return "error";
        }
        //得到库存数量
        String storageAmounting = storageDetail.getStorageAmounting();
        int storageAmountint_int = Integer.parseInt(storageAmounting);
        //库存数量减少,如果库存数量不足,跳出
        storageAmountint_int = storageAmountint_int - sellNumber_int;
        if (storageAmountint_int < 0) {
            return "no";
        }
        //保存修改后的信息
        storageAmounting = String.valueOf(storageAmountint_int);
        storageDetail.setStorageAmounting(storageAmounting);
        storageDetailRepository.save(storageDetail);
        save(request, m);
        return "yes";
    }
}
