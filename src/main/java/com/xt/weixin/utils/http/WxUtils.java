package com.xt.weixin.utils.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/***
 * 
 * @author Forest
 *
 */
public class WxUtils {
	//http客户端
	private static DefaultHttpClient httpclient;
	
	private static String appid ;
	
	private static String secret;
	
	private static String accessToken;
	
	
	static {
		httpclient = new DefaultHttpClient();
		httpclient = (DefaultHttpClient) HttpClientConnectionManager
				.getSSLInstance(httpclient); // 接受任何证书的浏览器客户端
	}
	/**
	 * 初始加载,初始化 appid,secret,accessToken
	 * @param appid
	 * @param secret
	 * @throws Exception
	 */
	public static void load(String appid,String secret) throws Exception{
		WxUtils.appid = appid;
		WxUtils.secret = secret;
		WxUtils.accessToken = getAccessToken(appid,secret);
	}
	
	
	/**
	 * 根据appid,secret获取accessToken
	 * @param appid
	 * @param secret
	 * @return
	 * @throws Exception
	 */
	private static String getAccessToken(String appid, String secret)
			throws Exception {
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="
						+ appid + "&secret=" + secret);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		return object.getString("access_token");
	}
	
	/**
	 *  创建菜单
	 * @param params  格式为
	 * 		String s = "{\"button\":[" +
	 *				"{\"type\":\"click\",\"name\":\"系统登录\",\"key\":\"V1001_LOGIN\"}," +
	 *				"{\"type\":\"view\",\"name\":\"测试\",\"url\":\""+url+"\"}" +
	 *				"]}"; 
	 * @return
	 * @throws Exception
	 */
	public static String createMenu(String params)
			throws Exception {
		HttpPost httpost = HttpClientConnectionManager
				.getPostMethod("https://api.weixin.qq.com/cgi-bin/menu/create?access_token="
						+ accessToken);
		httpost.setEntity(new StringEntity(params, "UTF-8"));
		HttpResponse response = httpclient.execute(httpost);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		System.out.println(jsonStr);
		JSONObject object = JSON.parseObject(jsonStr);
		return object.getString("errmsg");
	}
	/**
	 * 根据accessToken创建菜单
	 * @param params  格式为
	 * 		String s = "{\"button\":[" +
	 *				"{\"type\":\"click\",\"name\":\"系统登录\",\"key\":\"V1001_LOGIN\"}," +
	 *				"{\"type\":\"view\",\"name\":\"测试\",\"url\":\""+url+"\"}" +
	 *				"]}";
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	public static String createMenu(String params,String accessToken)
			throws Exception {
		WxUtils.accessToken = accessToken;
		return createMenu(params);
	}
	

	/**
	 * 查询菜单信息
	 * @return
	 * @throws Exception
	 */
	public static String getMenuInfo() throws Exception {
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/get?access_token="
						+ accessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		return jsonStr;
	}
	/**
	 * 根据accessToken查询菜单信息
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	public static String getMenuInfo(String accessToken) throws Exception {
		WxUtils.accessToken = accessToken;
		return getMenuInfo();
	}
	

	/**
	 * 删除菜单
	 * @return
	 * @throws Exception
	 */
	public static String deleteMenu() throws Exception {
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/cgi-bin/menu/delete?access_token="
						+ accessToken);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		return object.getString("errmsg");
	}
	/**
	 * 根据 accessToken删除菜单
	 * @param accessToken
	 * @return
	 * @throws Exception
	 */
	public static String deleteMenu(String accessToken) throws Exception {
		WxUtils.accessToken = accessToken;
		return deleteMenu();
	}
	
	
	/**
	 * 根据appid,secret,code获取openid
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getOpenId(String appid,String secret,String code) throws Exception{
		WxUtils.appid = appid;
		WxUtils.secret = secret;
		return WxUtils.getOpenId(code);
	}
	/**
	 * 根据code获取openid
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getOpenId(String code) throws Exception{
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code");
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		return object;
	}
	
	/**
	 * 根据nextOpenId获取底下的关注用户列表,nextOpenId为空的时候从头开始取
	 * @param nextOpenId
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getUserList(String nextOpenId) throws Exception{
		HttpGet get = null;
		if("".equals(nextOpenId) || nextOpenId == null){
			get = HttpClientConnectionManager
					.getGetMethod("https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken );
		}else{
			get = HttpClientConnectionManager
					.getGetMethod("https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken + "&next_openid=" + nextOpenId);
		}
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		return object;

	}
	/**
	 * 根据openId获取用户信息
	 * @param openId
	 * @param lang lang = "zh_CN" 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 * @throws Exception
	 */
	public static JSONObject getUserInfo(String openId,String lang) throws Exception{
		if("".equals(lang) || lang == null){
			lang = "zh_CN";
		}
		HttpGet get = HttpClientConnectionManager
				.getGetMethod("https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + accessToken + "&openid=" + openId + "&lang=" + lang);
		HttpResponse response = httpclient.execute(get);
		String jsonStr = EntityUtils.toString(response.getEntity(), "utf-8");
		JSONObject object = JSON.parseObject(jsonStr);
		return object;
	}
	
	public static JSONObject getUserInfo(String openId) throws Exception{
		return  getUserInfo(openId,"");
	}
}