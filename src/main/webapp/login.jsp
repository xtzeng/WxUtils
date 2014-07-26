<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBliC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="images/Default.css" type=text/css rel=stylesheet>
<link href="images/xtree.css" type=text/css rel=stylesheet>
<link href="images/User_Login.css" type=text/css rel=stylesheet>

<style type="text/css">
#IbtnEnter{
	background:url(images/user_botton.gif) no-repeat;
	width:100px;
	height:80px;
	border:0px;
	cursor:pointer;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="MSHTML 6.00.6000.16674" name=GENERATOR></HEAD>	
<title>用户登录</title>
</head>

<body  id=userlogin_body>


<div id=user_login>

<dl>
  <dd id=user_top>
  <ul>
    <li class=user_top_l></li>
    <li class=user_top_c></li>
    <li class=user_top_r></li></ul>
  <dd id=user_main>
  <ul>
    <li class=user_main_l></li>
    <li class=user_main_c>
    
    <div class=user_main_box>
    <form action="user.doLogin.action">
    
    <ul>
      <li class=user_main_text>用户名： </li>
      <li class=user_main_input>
      <input class=TxtUserNameCssClass id=TxtUserName maxLength=20 name=TxtUserName> 
      </li>
   </ul>
      
    <ul>
      <li class=user_main_text>密 码： </li>
      <li class=user_main_input>
          <input class=TxtPasswordCssClass id=TxtPassword type=password name=TxtPassword>
      </li>
    </ul>
      
      
    <ul>
      <li class=user_main_text>Cookie： </li>
      <li class=user_main_input>
      	<select id=DropExpiration name=DropExpiration> 
        <option value=None selected>不保存</option> 
        <option value=Day>保存一天</option> 
        <option value=Month>保存一月</option> 
        <option value=Year>保存一年</option></select> 
     </li>
    </ul>
    
    </form>
    </div></li>
    <li class=user_main_r>
	    <input class=IbtnEnterCssClass id="IbtnEnter"  
	           style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; BORDER-RIGHT-WIDTH: 0px" 
	           type="submit"  name=IbtnEnter value="">
    </li>
    
    </ul>
    
  <dd id=user_bottom>
  <ul>
    <li class=user_bottom_l></li>
    <li class=user_bottom_c><span style="MARGIN-TOP: 40px">如果您想获得更多后台模板，请点此 <a href="http://www.baidu.com">源码之家</a> 。</span> </li>
    <li class=user_bottom_r></li>
  </ul>
  </dd>
  
  </dl>
    </div>
    <span id=ValrUserName style="DISPLAY: none; COLOR: red"></span>
    <span id=ValrPassword style="DISPLAY: none; COLOR: red"></span>
    <span id=ValrValidateCode style="DISPLAY: none; COLOR: red"></span>


<div id=ValidationSummary1 style="DISPLAY: none; COLOR: red"></div>




</body>
</html>