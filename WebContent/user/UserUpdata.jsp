<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = "" + request.getScheme() + "://" + request.getHeader("host") + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=path%>">
<title>修改个人信息</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/CreateIndent.css" />
<link type="text/css" rel="stylesheet" href="css/login.css" />
</head>
<body>

	<div class="border_top_cart">
		<div class="container">
			<div class="checkout-box">
				<form action="#" method="post">
					<div class="checkout-box-bd">
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">修改个人信息</h2>
							</div>
							<form action="#" method="post">
								<div>
									<!--用户头像：<input type="text" name="address_tel" id="address_tel" placeholder="请输入送址电话" /><br/><br/>-->
									用户名：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="user_name"
										id="user_name" placeholder="请输入用户名" /><br />
									<br /> 用户密码：<input type="password" name="user_pwd"
										id="user_pwd" placeholder="请输入密码" /><br />
									<br /> 用户电话：<input type="text" name="user_tel" id="user_tel"
										placeholder="请输入用户电话" /><br />
									<br /> 
										<a href="user/AddressShowInsert.jsp">
											<div style="height: 1em; width: 15em">
												<input type="button" value="查看地址" class="login_button_submit" />
											</div>
										</a>
									<br /> <a href="#" class="btn btn-primary">保存该信息</a>
								</div>
							</form>
						</div>
					</div>
					<div class="checkout-confirm">
						<a href="#" class="btn btn-lineDakeLight btn-back-cart">返回首页</a> <a
							href="#" class="btn btn-primary">刷新个人信息</a>
					</div>
			</div>
		</div>
	</div>
</body>
</html>
