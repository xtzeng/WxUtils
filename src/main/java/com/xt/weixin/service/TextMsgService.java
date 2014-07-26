package com.xt.weixin.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.xt.weixin.common.vo.LinkResponseVO;
import com.xt.weixin.common.vo.PictureTextResponseVO;
import com.xt.weixin.common.vo.TextResponseVO;
import com.xt.weixin.common.vo.TextResquestVO;
import com.xt.weixin.common.vo.WeixinVO;
import com.xt.weixin.dao.TextMsgDao;
import com.xt.weixin.po.TextMsg;
import com.xt.weixin.utils.PropertiesConfig;


/**
 * 用于处理微信用户发送的文本信息
 * @author Administrator
 *
 */
@Service("textMsgService")
public class TextMsgService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="textMsgDao")
	private TextMsgDao textMsgDao;
	
	
	/**
	 * 根据用户的绑定状态返回不同的信息给用户
	 * @param requestVO
	 * @return
	 */
	public TextResponseVO handleTextMsg(TextResquestVO requestVO){
		logger.info(requestVO.toString());
		TextResponseVO responseVO = new TextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("text");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setContent("请点击该链接进入手机百度:<a href='http://m.baidu.com/'>登录系统</a>");
		
		return responseVO;
	}
	

	public PictureTextResponseVO handlePictureMessage(WeixinVO requestVO){
		
        PictureTextResponseVO responseVO = new PictureTextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("news");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setArticleCount(1);
		List<PictureTextResponseVO.Item> list =  new ArrayList<PictureTextResponseVO.Item>();
		
		PictureTextResponseVO.Item i1 = responseVO.new Item();
		i1.setTitle("你好世界！");
		i1.setDescription("this is a description");
		i1.setPicUrl(PropertiesConfig.getInstance().get("sys.url")+"images/nba_allstar.jpg");
		i1.setUrl(PropertiesConfig.getInstance().get("jsp.url")+"index.html?openId="+openId);
		list.add(i1);
		
		responseVO.setArticles(list);
		return responseVO;
	}


	public Object handleLinkMessage(TextResquestVO requestVO) {
		logger.info(requestVO.toString());
		LinkResponseVO responseVO = new LinkResponseVO();
		
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("link");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setUrl(PropertiesConfig.getInstance().get("sys.url")+"login.jsp");
		responseVO.setTitle("this a title");
		responseVO.setDescription("this is a description");
		return responseVO;
	}
	
}
