package com.imooc.pay.service;

import java.math.BigDecimal;

/**
 * Created by 廖师兄
 */
public interface IPayService {

	/**
	 * 创建/发起支付
	 */
	void create(String orderId, BigDecimal amount);
}
