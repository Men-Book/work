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
    <title>查看和新增地址</title>
    <link href="css/public.css" type="text/css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/base.css"/>
    <link rel="stylesheet" type="text/css" href="css/CreateIndent.css" />
</head>
<body>

<div class="border_top_cart">
    <div class="container">
        <div class="checkout-box">
            <form  action="#" method="post">
                <div class="checkout-box-bd">
                    <div class="xm-box">
                        <div class="box-hd ">
                            <h2 class="title">收货地址</h2>
                        </div>
                        <div class="box-bd">
                            <div class="clearfix xm-address-list" id="checkoutAddrList">
                                <dl class="item" >
                                    <dt>
                                        <strong class="itemConsignee">潘骏杰</strong>
                                        <span class="itemTag tag">家</span>
                                    </dt>
                                    <dd>
                                        <p class="tel itemTel">15961726437</p>
                                        <!--<p class="itemRegion">江苏 无锡市 北塘区</p>--><br>
                                        <p class="itemStreet">民丰西苑82号202室</p>
                                        <a href="#" class="btn btn-primary">修改地址</a>
                                    </dd>
                                </dl>

                            </div>
                            <!--class="clearfix xm-address-list" id="checkoutAddrList"-->
                            <div class="box-hd ">
                                <h2 class="title">新增地址</h2>
                            </div>
                            <form action="#" method="post">
                                <div>
                                    <input type="text" name="address_name" id="address_name" placeholder="请输入地址" /><br/><br/>
                                    <input type="text" name="address_tel" id="address_tel" placeholder="请输入送址电话" /><br/><br/>
                                    <input type="text" name="user_name" id="user_name" placeholder="请输入用户名" /><br/><br/>
                                    <a href="#" class="btn btn-primary">保存该地址</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="checkout-confirm">
                        <a href="#" class="btn btn-lineDakeLight btn-back-cart">返回首页</a>
                        <a href="#" class="btn btn-primary">刷新地址</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
