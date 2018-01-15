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
<title>修改商家信息</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/CreateIndent.css" />
<link type="text/css" rel="stylesheet" href="css/login.css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>

<div class="border_top_cart">
	<div class="container">
		<div class="checkout-box">
			<div class="checkout-box-bd">
				<div class="xm-box">
					<div class="box-hd ">
						<h2 class="title">修改商家信息</h2>
					</div>
					<!--  <form action="HotelUpdateServlet" method="post">-->
						<div id="show_information">
							商家名名：<input type="text" name="hotel_name" id="hotel_name" />
									<br />
									<br /> 
							商家密码：<input type="password" name="hotel_pwd" id="hotel_pwd" />
									<br />
									<br /> 
							商家电话：<input type="text" name="hotel_tel" id="hotel_tel"  /><br />
									<br /> 
							商家地址：<input type="text" name="hotel_address" id="hotel_address" /><br />
									<br /> 
							商家描述：<input type="text" name="hotel_description" id="hotel_description" /><br />
									<br /> 
							<input type="button" class="btn btn-primary" id="submit_update" value="保存修改信息"/>
						</div>
					<!-- </form>-->
				</div>
			</div>
			<div class="checkout-confirm">
				<a href="hotel/HotelMealShow.jsp" class="btn btn-lineDakeLight btn-back-cart">返回首页</a>
				<input type="button" class="btn btn-primary" id="submit_return" value="刷新商家信息"/> 
			</div>
		</div>
	</div>
</div>

</body>
<script type="text/javascript">
	$(document).ready(function(){		
		$("#submit_update").bind("click",function(){
			if($("input#hotel_name").val() && $("input#hotel_pwd").val()){//不为空
				//处理
				var data = {};
				data["hotel_name"] = $("input#hotel_name").val();
				data["hotel_pwd"] = $("input#hotel_pwd").val();
				data["hotel_tel"] = $("input#hotel_tel").val();
				data["hotel_address"] = $("input#hotel_address").val();
				data["hotel_description"] = $("input#hotel_description").val();
				$.ajax({
					type:"post",
					url:"HotelUpdateServlet",
					data:data,
					cache:false,
					dataType:'json',
					success:function(data){
						html = "";
						$.each(data,function(index,item){
								html += '商家名名：<input type="text" name="hotel_name" id="hotel_name" value="' + item.hotel_name +'" /><br /><br />';
								html += '商家密码：<input type="password" name="hotel_pwd" id="hotel_pwd" value="'+ item.hotel_pwd +'" />	<br /><br /> ';
								html += '商家电话：<input type="text" name="hotel_tel" id="hotel_tel" value="'+ item.hotel_tel +'" /><br /><br /> ';
								html += '商家地址：<input type="text" name="hotel_address" id="hotel_address" value="'+ item.hotel_address +'" /><br /><br />';
								html += '商家描述：<input type="text" name="hotel_description" id="hotel_description" value="'+ item.hotel_description +'" /><br /><br />';
								html += '<input type="button" value="保存该信息" class="btn btn-primary" id = "submit_update"/>';
							});
							$("#show_information").html(html);
							$("#submit_return").val("修改成功！");
							$("#submit_update").val("修改成功！");
						}
					});				
			}else{
				$("#submit_return").val("用户名密码为空啦！");
				$("#submit_update").val("用户名密码为空啦！");
			}	
		});
	});
	
	
</script>
</html>
