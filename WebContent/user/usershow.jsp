<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = "" + request.getScheme() + "://" + request.getHeader("host") + request.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=path%>">
<link href="css/UserShow.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<title>订餐管理系统</title>
</head>
<body>
	<header>
	<div class="hotel_logo">
			<img src="images/logo.png" width="48px" height="48px"/>
	</div>
	<div class="usershop_login">
		<span class="login_people"><img src="images/6.png" /></span> <a
			href="#">欢迎您*${USER.user_name }*</a>
	</div>
	<div class="usershop_indent">
			<a href="UserSelectIndentServlet">我的订单</a>
	</div>
	</header>
	<div class="show_list">
		<div class="meau_left">
		<div class="meau_style_img">
				<li><img src="images/style.png" width="32px" height="32px"></li>
				<li><img src="images/addstyle_blue.png" width="32px" height="32px"></li>
				<li><img src="images/addmeal_yellow.png" width="32px" height="32px"></li>
			</div>
			<div class="meau_style_hotel">
				<h3>&nbsp;&nbsp;商家简介:</h3>
				<p>&nbsp;&nbsp;发生的符合三水电费空间哈</p>
				<p>&nbsp;&nbsp;多少分但是返回的算法第三方是</p>
				<p>&nbsp;&nbsp;是否能啊时代峻峰</p>
				<p>&nbsp;&nbsp;多少分但是返回的算法第三方是</p>
				<p>&nbsp;&nbsp;是否能啊时代峻峰</p>
			</div>
		
		<c:forEach items="${STYLELIST }" var="stylelist">
			<div class="meau_style">
				<a href="javascript:void(0);" onclick="getMeal(${stylelist.style_id });">${stylelist.style_name }</a>
			</div>
		</c:forEach>
			
		</div>

		<div class="meau_right" id="inner_html">
			<c:forEach items="${MEALLIST }" var="meallist">
				<div class="meau_meal">
				<div class="meau_meal_img">
					<img src="images/1.jpg" />
				</div>
				<div class="meau_txt">
					<p>
						菜名:<b>${meallist.meal_name }</b>
					</p>
					<p>
						菜品简介：<b>${meallist.meal_description }</b>
					</p>
					<p class="meau_price">价格：￥${meallist.meal_price }</p>
				</div>
				<!--
                	作者：offline
                	时间：2018-01-11
                	描述：此处的标签a用来用于Servlet跳转
                	<a href="UserSubmitIndentServlet?page = 1">大盘鸡</a>
                -->
				<a href="UserSubmitIndentServlet?string_meal_id=${meallist.meal_id }">下单</a>
			</div>
			</c:forEach>			
		</div>
	</div>

	<footer>
	<div class="links">
		<a href="#">关于我们</a> |<a href="#">联系我们</a> |<a href="#">人才招聘</a> |<a
			href="#">商家入驻</a> |<a href="#">手机点餐</a> |<a href="#">友情链接</a> |<a
			href="#">点餐社区</a> |<a href="#">餐厅工艺</a> |<a href="#">English Site</a>
	</div>
	<div class="conpright">Copyright © 2018 软件OAM.com 版权所有</div>
	</footer>
</body>
<script type="text/javascript">
	function getMeal(style_id){
		var data = {};
		data["style_id"] = style_id;
		$.ajax({
			type:"POST",
			url:"UserMealShowServlet",
			data: data,
			cache: false,
			dataType: 'json',
			success:function(data){
				var html="";
				$.each(data,function(index,item){
					html+='<div class="meau_meal">';
					html+='<div class="meau_meal_img">';
					html+='<img src="images/1.jpg" />';
					html+='</div>';
					html+='<div class="meau_txt">';
					html+='<p>';
					html+='菜名:<b>'+item.meal_name+'</b>';
					html+='</p><p>';
					html+='菜品简介：<b>'+item.meal_description+'</b>';
					html+='</p>';
					html+='<p class="meau_price">价格：￥'+item.meal_price+'</p>';
					html+='</div>';
					html+='<a href="UserSubmitIndentServlet?string_meal_id=' + item.meal_id + '">下单</a></div>';
				})
				$("#inner_html").html(html);
			}
		});
	}
</script>
</html>