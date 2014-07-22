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
		responseVO.setContent("请点击该链接进入系统:<a href='www.baidu.com'>登录系统</a>");
		
		return responseVO;
	}
	
	/**
	 * 人气新星
	 * @param requestVO
	 * @return
	 */
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
		i1.setUrl(PropertiesConfig.getInstance().get("sys.url")+"index.jsp?openId="+openId);
		list.add(i1);
		
		responseVO.setArticles(list);
		return responseVO;
	}
	
	
	public TextResponseVO handleLoginTextMsg(WeixinVO requestVO){
		TextResponseVO responseVO = new TextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("text");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
//		responseVO.setContent("请点击进入系统:<a href='"
//				+ SystemConfigs.getInstance().get("system.url") + "/user.home.action?openId="+openId+"'>登录系统</a>" );
//		
		
		return responseVO;
	}
	
	public TextResponseVO handleLoginTextContact(WeixinVO requestVO){
		TextResponseVO responseVO = new TextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("text");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setContent("订台热线：0592-2923333,2923888\n包厢预定,消费咨询,活动咨询,\n客服电话：0592-2200067\n投诉建议,服务咨询,问题反映,\n 总督察：15960803020\n终极投诉  违纪举报" );
		
		
		return responseVO;
	}
	
	
	/**
	 * 如鱼得水
	 * @param requestVO
	 * @return
	 */
	public PictureTextResponseVO handlePictureTextFish(WeixinVO requestVO){
		
        PictureTextResponseVO responseVO = new PictureTextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("news");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setArticleCount(4);
		List<PictureTextResponseVO.Item> list =  new ArrayList<PictureTextResponseVO.Item>();
		PictureTextResponseVO.Item i1 = responseVO.new Item();
		i1.setTitle("12星座美女谁最性感");
		i1.setDescription("如果说有一种人自出生就带着一种性感的话，那么就是天蝎了，而且她们都有着一种咄咄逼人的气势，遇到她们就好像被丘比特之箭射...");
		//i1.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/fish_01.jpg");
		//i1.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/starGoddess.jsp?openId="+openId);
		list.add(i1);
		
		PictureTextResponseVO.Item i2 = responseVO.new Item();
		i2.setTitle("约会必知：情人点餐的礼仪");
		i2.setDescription(" 很多人不清楚，在约会时也要注重点餐礼仪。两人在进入餐厅后，女方不可以擅自点菜，而是要将主动权交到男方手中，可以给男方...");
		//i2.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/datingKnowledge.jpg");
		//i2.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/datingKnowledge.jsp?openId="+openId);
		list.add(i2);
		
		PictureTextResponseVO.Item i3 = responseVO.new Item();
		i3.setTitle("初次约会：十个话题轻松聊");
		i3.setDescription("第一次和心仪的女生约会，难免会紧张，都担心聊的话题不讨喜。其实，第一次约会聊天并没有那么难，首先从轻松的谈话开始，一步...");
		//i3.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/firstDate.jpg");
		//i3.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/firstDate.jsp?openId="+openId);
		list.add(i3);
		
		PictureTextResponseVO.Item i4 = responseVO.new Item();
		i4.setTitle("与12星座交友的技巧");
		i4.setDescription("她们喜欢别人肯定她们的想法， 虽然自己心中已有答案 ,却常常需要别人再次肯定 . 只有这样她们才会安心 .如果你说的话正和她的...");
		//i4.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/datingTips_01.jpg");
		//i4.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/datingTips.jsp?openId="+openId);
		list.add(i4);
		
		responseVO.setArticles(list);
		return responseVO;
	}
	
	
	
	
	/**
	 * 一步到位
	 * @param requestVO
	 * @return
	 */
	public PictureTextResponseVO handlePictureTextStep(WeixinVO requestVO){
		
        PictureTextResponseVO responseVO = new PictureTextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("news");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setArticleCount(4);
		List<PictureTextResponseVO.Item> list =  new ArrayList<PictureTextResponseVO.Item>();
		
		PictureTextResponseVO.Item i1 = responseVO.new Item();
		i1.setTitle("");
		i1.setDescription("");
		//i1.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/comeAndFindMe.jpg");
		//i1.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/carNavigation.jsp?openId="+openId);
		list.add(i1);
		
		PictureTextResponseVO.Item i2 = responseVO.new Item();
		i2.setTitle("自驾导航\n成功大道出口处");
		i2.setDescription("自驾导航\n成功大道出口处");
		//i2.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/carNavigation.jpg");
		//i2.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/carNavigation.jsp?openId="+openId);
		list.add(i2);
		
		PictureTextResponseVO.Item i3 = responseVO.new Item();
		i3.setTitle("驾车指导\n街道商铺信息平面图");
		i3.setDescription("驾车指导\n街道商铺信息平面图");
		//i3.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/drivingGuide.jpg");
		//i3.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/drivingGuide.jsp?openId="+openId);
		list.add(i3);
		
		PictureTextResponseVO.Item i4 = responseVO.new Item();
		i4.setTitle("绿色出行\n公交、BRT");
		i4.setDescription("绿色出行\n公交、BRT");
		//i4.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/images/greenTravel.jpg");
		//i4.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/reward/greenTravel.jsp?openId="+openId);
		list.add(i4);
		
		responseVO.setArticles(list);
		return responseVO;
	}
	
	
	/**
	 * 反馈专区
	 * @param requestVO
	 * @return
	 */
	public PictureTextResponseVO handlePictureTextFeedBack(WeixinVO requestVO){
		
        PictureTextResponseVO responseVO = new PictureTextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("news");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setArticleCount(4);
		List<PictureTextResponseVO.Item> list =  new ArrayList<PictureTextResponseVO.Item>();
		
		PictureTextResponseVO.Item i1 = responseVO.new Item();
		i1.setTitle("反馈专区");
		i1.setDescription("反馈专区");
		//i1.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/enjoy/images/feedBack_01.jpg");
		//i1.setUrl(SystemConfigs.getInstance().get("system.url")+"/feedback.show.action?openId="+openId+"&type=1");
		list.add(i1);
		
		PictureTextResponseVO.Item i2 = responseVO.new Item();
		i2.setTitle("员工服务\n如有什么意见或建议，请向我们反馈。");
		i2.setDescription("员工服务\n如有什么意见或建议，请向我们反馈。");
		//i2.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/enjoy/images/feedBack_02.jpg");
		//i2.setUrl(SystemConfigs.getInstance().get("system.url")+"/feedback.show.action?openId="+openId+"&type=1");
		list.add(i2);
		
		PictureTextResponseVO.Item i3 = responseVO.new Item();
		i3.setTitle("酒水食物\n如有什么意见或建议，请向我们反馈。");
		i3.setDescription("酒水食物\n如有什么意见或建议，请向我们反馈。");
		//i3.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/enjoy/images/feedBack_03.jpg");
		//i3.setUrl(SystemConfigs.getInstance().get("system.url")+"/feedback.show.action?openId="+openId+"&type=2");
		list.add(i3);
		
		PictureTextResponseVO.Item i4 = responseVO.new Item();
		i4.setTitle("环境节目\n如有什么意见或建议，请向我们反馈。");
		i4.setDescription("环境节目\n如有什么意见或建议，请向我们反馈。");
		//i4.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/enjoy/images/feedBack_04.jpg");
		//i4.setUrl(SystemConfigs.getInstance().get("system.url")+"/feedback.show.action?openId="+openId+"&type=3");
		list.add(i4);
		
		responseVO.setArticles(list);
		return responseVO;
	}
	
	
	/**
	 * 人气新星
	 * @param requestVO
	 * @return
	 */
	public PictureTextResponseVO handlePictureTextPopularStar(WeixinVO requestVO){
		
        PictureTextResponseVO responseVO = new PictureTextResponseVO();
		String openId = requestVO.getFromUserName();
		responseVO.setToUserName(requestVO.getFromUserName());
		responseVO.setFromUserName(requestVO.getToUserName());
		responseVO.setMsgType("news");
		Date now = new Date();
		responseVO.setCreateTime(now.getTime());
		responseVO.setArticleCount(2);
		List<PictureTextResponseVO.Item> list =  new ArrayList<PictureTextResponseVO.Item>();
		
		PictureTextResponseVO.Item i1 = responseVO.new Item();
		i1.setTitle("一代佳人2014“人气宝贝”");
		i1.setDescription("人气风云榜");
		i1.setPicUrl("114.215.125.186/WxUtils/images/nba_allstar.jpg");
		//i1.setUrl(SystemConfigs.getInstance().get("system.url")+"/starInfo.hotStar.action?openId="+openId);
		list.add(i1);
		
		PictureTextResponseVO.Item i2 = responseVO.new Item();
		i2.setTitle("活动详情\n点击详情 >>");
		i2.setDescription("活动详情\n点击详情 >>");
		//i2.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/residence/images/detail.jpg");
		//i2.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/residence/activityDetailInfo.jsp?openId="+openId);
		list.add(i2);
		
		/*PictureTextResponseVO.item i3 = responseVO.new item();
		i3.setTitle("足球宝贝\n点击详情 >>");
		i3.setDescription("足球宝贝\n点击详情 >>");
		i3.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/residence/images/popularStar_04.jpg");
		i3.setUrl(SystemConfigs.getInstance().get("system.url")+"/starInfo.hotStar.action?openId="+openId);
		list.add(i3);*/
		
		/*PictureTextResponseVO.item i4 = responseVO.new item();
		i4.setTitle("最新佳丽\n点击详情 >>");
		i4.setDescription("最新佳丽\n点击详情 >>");
		i4.setPicUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/residence/images/popularStar_04.jpg");
		i4.setUrl(SystemConfigs.getInstance().get("system.url")+"/subscription/residence/newBaby.jsp?openId="+openId);
		list.add(i4);*/
		
		responseVO.setArticles(list);
		return responseVO;
	}
	
	
}
