package com.source.proxy;
/** 
 *
 * @author WX773082 wangcong
 * @date 2020-09-07
 */
public class SmsServiceImpl implements SmsService {

	public String send(String message) {
		System.out.println("send message:" + message);
		return message;
	}

}
