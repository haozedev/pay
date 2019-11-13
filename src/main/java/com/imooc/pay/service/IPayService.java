package com.imooc.pay.service;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayResponse;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 */
public interface IPayService {

	/**
	 * 创建/发起支付
	 */
	PayResponse create(String orderId, BigDecimal amount, BestPayTypeEnum bestPayTypeEnum);

	/**
	 * 异步通知处理
	 * @param notifyData
	 */
	String asyncNotify(String notifyData);
}
