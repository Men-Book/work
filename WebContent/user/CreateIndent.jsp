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
<title>订单详情</title>
<link href="css/public.css" type="text/css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="css/base.css" />
<link rel="stylesheet" type="text/css" href="css/CreateIndent.css" />
</head>
<body>

	<div class="border_top_cart">
		<div class="container">
			<div class="checkout-box">
				<form action="CreateIndentServlet" method="post">
					<div class="checkout-box-bd">
						<div class="xm-box">
							<div class="box-hd ">
								<h2 class="title">收货地址</h2>
							</div>
							<div class="box-bd">
								<div class="clearfix xm-address-list" id="checkoutAddrList">
									<c:forEach items="${ADDRESSLIST }" var="addresslist">
										<dl class="item">
											<dt>
												<strong class="itemConsignee">${USER.user_name }</strong> 
												<span class="itemTag tag"><input type="radio" name="type" value="${addresslist.address_id }">家</span>
											</dt>
											<dd>
												<p class="tel itemTel">${addresslist.address_tel }</p>
												<p class="itemStreet">${addresslist.address_name }</p>
											</dd>
										</dl>
									</c:forEach>
									<div class="item use-new-addr" id="J_useNewAddr">
										<a href="#" class="btn btn-lineDakeLight btn-back-cart">新增地址</a>
									</div>
								</div>
							</div>
						</div>
						<div class="checkout-box-ft">
							<div id="checkoutGoodsList" class="checkout-goods-box">
								<div class="xm-box">
									<div class="box-hd">
										<h2 class="title">确认订单信息</h2>
									</div>
									<div class="box-bd">
										<dl class="checkout-goods-list">
											<dt class="clearfix">
												<span class="col col-1">餐品名称</span> <span class="col col-2">菜系</span>
												<span class="col col-3">购买数量</span> <span class="col col-4">购买价格</span>
											</dt>
											<dd class="item clearfix">
												<div class="item-row">
													<div class="col col-1">
														<div class="g-pic">
															<img src="${MEAL.meal_img }" width="40" height="40" />
														</div>
														<div class="g-info">${MEAL.meal_name }</div>
													</div>
													<div class="col col-2">${STYLE.style_name }</div>
													<div class="col col-3">1</div>
													<div class="col col-4">￥${MEAL.meal_price }</div>
												</div>
											</dd>
										</dl>
										<div class="checkout-count clearfix">
											<div class="checkout-count-extend xm-add-buy">
												<h2 class="title">订单备注</h2>
												<br> <input type="text" name = "indent_txt" id="indent_txt"/>

											</div>
											<div class="checkout-price">
												<ul>
													<li>订单总额：<span>${MEAL.meal_price }元</span>
													</li>
													<li>活动优惠：<span>-0元</span>
													</li>
													<li>优惠券抵扣：<span id="couponDesc">-0元</span>
													</li>
													<li>运费：<span id="postageDesc">0元</span>
													</li>
												</ul>
												<p class="checkout-total">
													应付总额：<span><strong id="totalPrice">${MEAL.meal_price }</strong>元</span>
												</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="checkout-confirm">
							<a href="user/usershow.jsp" class="btn btn-lineDakeLight btn-back-cart">返回首页</a>
							<input type="submit" class="btn btn-primary" value="立即下单" id="" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
