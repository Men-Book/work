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
<title>餐馆的订单记录</title>
<link href="css/public.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" type="text/css" href="css/base.css"/>
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
</head>
<body>
	<div class="border_top_cart">
		<div class="container payment-con">
			<div>
				<a href="HotelSelectIndentServlet" class="btn btn-lineDakeLight btn-back-cart">刷新订单</a> <a
					href="hotel/HotelMealShow.jsp" class="btn btn-lineDakeLight btn-back-cart">返回首页</a>
			</div>
			<c:forEach items="${NY }" var="ny">
			<div class="order-info">
				<div class="msg">
					<h3>餐馆名称：</h3>
					<p>餐品名称：${ny.meal_name }</p>
					<p class="post-date">订单状态：商家未接单</p>
				</div>
				<div class="info">
					<p>
						金额：<span class="pay-total">${ny.indent_price }元</span>
					</p>
					<p>订单备注：${ny.indent_txt }</p>
					<p>订单时间：${ny.indent_time }</p>
					<p>
						详情：${ny.user_name } <span class="line">/</span> ${ny.address_tel } <span class="line">/</span>
						${ny.address_name }<span class="line">/</span>
					</p>
					<a href="hotel/HotelUpdateIndent.jsp?indent_id=${ny.indent_id }&meal_name=${ny.meal_name }&meal_img=${ny.meal_img }" class="btn btn-primary">修改订单</a>
				</div>
				<div class="icon-box">
					<!--<div class="picdiv">-->
					<img src="${ny.meal_img }" width="100%" height="100%">
					<!--</div>-->
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>