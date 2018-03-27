package com.cms.service.Impl;

import com.cms.Presenter.SellDetailPresenter;
import com.cms.entity.SellDetail;
import com.cms.repository.SellDetailRepository;
import com.cms.service.ISellDetailService;
import org.springframework.stereotype.Service;

@Service
public class SellDetailServiceImpl extends BaseServiceImpl<SellDetail, SellDetailRepository, SellDetailPresenter> implements ISellDetailService {
}
