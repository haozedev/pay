package com.imooc.pay.service.impl;

import com.imooc.pay.service.IPayService;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 */
public class PayService implements IPayService {

	/**
	 * 创建/发起支付
	 *
	 * @param orderId
	 * @param amount
	 */
	@Override
	public void create(String orderId, BigDecimal amount) {
		WxPayConfig wxPayConfig = new WxPayConfig();
		wxPayConfig.setAppId();
		wxPayConfig.setMchId();
		wxPayConfig.setMchKey();

		BestPayServiceImpl bestPayService = new BestPayServiceImpl();
		bestPayService.setWxPayConfig(wxPayConfig);

		PayRequest request = new PayRequest();

		bestPayService.pay()
	}
}
