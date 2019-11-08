package com.imooc.pay.service.impl;

import com.imooc.pay.service.IPayService;
import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.BestPayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 */
@Slf4j
@Service
public class PayService implements IPayService {

	@Autowired
	private BestPayService bestPayService;

	/**
	 * 创建/发起支付
	 *
	 * @param orderId
	 * @param amount
	 */
	@Override
	public PayResponse create(String orderId, BigDecimal amount) {
		//写入数据库
		PayRequest request = new PayRequest();
		request.setOrderName("4559066-最好的支付sdk");
		request.setOrderId(orderId);
		request.setOrderAmount(amount.doubleValue());
		request.setPayTypeEnum(BestPayTypeEnum.WXPAY_NATIVE);

		PayResponse response = bestPayService.pay(request);
		log.info("response={}", response);

		return response;
	}

	/**
	 * 异步通知处理
	 *
	 * @param notifyData
	 */
	@Override
	public void asyncNotify(String notifyData) {
		//1. 签名检验
		PayResponse payResponse = bestPayService.asyncNotify(notifyData);
		log.info("payResponse={}", payResponse);

		//2. 金额校验（从数据库查订单）

		//3. 修改订单支付状态
	}
}
