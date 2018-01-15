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
<title>修改订单状态</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/buyConfirm.css" />
</head>

<body>
	<div class="border_top_cart">
		<div class="container payment-con">
			<div>
				<a href="HotelSelectIndentServlet" class="btn btn-lineDakeLight btn-back-cart">刷新订单</a> 
				<a href="HoterlMealShow.jsp" class="btn btn-lineDakeLight btn-back-cart">返回首页</a>
			</div>
			<form action="HotelAlterIndentServlet" method="post">
				<div class="order-info">
					<div class="msg">
						<h3>
							订单ID：<%=request.getParameter("indent_id")%></h3>
						<p>
							餐品名称：<%=request.getParameter("meal_name")%></p>
						<p class="post-date">修改订单状态</p>
					</div>
					<div class="info">
						<p>
							<input type="radio" name="type" value="1" />商家未接单 <span
								class="line">&nbsp;</span> <input type="radio" name="type"
								value="2" />商家拒绝接单 <span class="line">&nbsp;</span> <input
								type="radio" name="type" value="3" />商家已接单 <span class="line">&nbsp;</span>
							<input type="radio" name="type" value="4" />商家正在派送 <span
								class="line">&nbsp;</span> <input type="radio" name="type"
								value="5" />已送达 <span class="line">&nbsp;</span> <input
								type="radio" name="type" value="6" />该订单结束
						</p>
						<input type="submit" class="btn btn-primary" value="保存修改" id="" />
					</div>
					<div class="icon-box">
						<!--<div class="picdiv">-->
						<img src="<%=request.getParameter("meal_img")%>" width="100%" height="100%">
						<!--</div>-->
					</div>
				</div>
			</form>
		</div>
	</div>
	</div>
</body>
</html>