package com.imooc.pay.service.impl;

import com.imooc.pay.service.IPayService;
import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 */
@Slf4j
@Service
public class PayService implements IPayService {

	/**
	 * 创建/发起支付
	 *
	 * @param orderId
	 * @param amount
	 */
	@Override
	public PayResponse create(String orderId, BigDecimal amount) {
		WxPayConfig wxPayConfig = new WxPayConfig();
		wxPayConfig.setAppId("wxd898fcb01713c658");
		wxPayConfig.setMchId("1483469312");
		wxPayConfig.setMchKey("098F6BCD4621D373CADE4E832627B4F6");
		wxPayConfig.setNotifyUrl("http://127.0.0.1");

		BestPayServiceImpl bestPayService = new BestPayServiceImpl();
		bestPayService.setWxPayConfig(wxPayConfig);

		PayRequest request = new PayRequest();
		request.setOrderName("4559066-最好的支付sdk");
		request.setOrderId(orderId);
		request.setOrderAmount(amount.doubleValue());
		request.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);

		PayResponse response = bestPayService.pay(request);
		log.info("response={}", response);

		return response;
	}
}
