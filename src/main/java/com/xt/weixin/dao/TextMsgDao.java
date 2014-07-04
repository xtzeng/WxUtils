package com.xt.weixin.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xt.weixin.po.TextMsg;


@Repository("textMsgDao")
public class TextMsgDao {
	
	public List<TextMsg> find(String type) throws SQLException {
		String sql = "select * from text_msg where type=? order by seq asc";
		//return this.baseTemplateDao.select(sql, new Object[]{type}, TextMsg.class);
		return null;
	}
}
