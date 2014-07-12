package com.xt.weixin.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.Result;
import com.xt.weixin.action.base.BaseAction;

@Controller("helloAction")
@Scope("prototype")
public class HelloAction extends BaseAction{

	/**
	 */
	private static final long serialVersionUID = 1L;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public Result test() {
		
		logger.info("hello ===========jj");
		return dispatch("/jsp/test.jsp");
	}
}
