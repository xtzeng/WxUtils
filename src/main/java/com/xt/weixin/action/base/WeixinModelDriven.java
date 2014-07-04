package com.xt.weixin.action.base;

import com.xt.weixin.common.vo.WeixinVO;



/**
 * 微信的模型驱动接口
 * @author Administrator
 *
 */
public interface WeixinModelDriven {
	
	/**
	 * 设置微信接收xml的对象
	 * @return
	 */
	public void setWeixinModel(WeixinVO weixinModel);
}
