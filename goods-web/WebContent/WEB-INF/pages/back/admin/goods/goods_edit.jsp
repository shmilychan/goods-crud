<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<base href="<%=basePath%>"/>
<title>商品管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="jquery/jquery.validate.min.js"></script>
<script type="text/javascript" src="jquery/additional-methods.min.js"></script>
<script type="text/javascript" src="jquery/Message_zh_CN.js"></script>
<script type="text/javascript" src="js/back/admin/goods/goods_edit.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head> 
<%!
	public static final String GOODS_EDIT_URL = "pages/back/admin/goods/edit.action" ;
%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form action="<%=GOODS_EDIT_URL%>" method="post" class="form-horizontal" id="goodsForm" enctype="multipart/form-data">
					<fieldset>
						<legend>
							<label><span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑商品</label>
						</legend>
						<div class="form-group" id="titleDiv">
							<label class="col-md-2 control-label" for="title">商品名称：</label>
							<div class="col-md-5">
								<input type="text" id="title" name="title" class="form-control" placeholder="请填写商品名称" value="${goods.title}">
							</div>
							<span class="col-md-5" id="titleSpan">*</span>
						</div>
						<div class="form-group" id="priceDiv">
							<label class="col-md-2 control-label" for="price">商品价格：</label>
							<div class="col-md-5">
								<input type="text" id="price" name="price" class="form-control" placeholder="请填写商品单价" value="${goods.price}">
							</div>
							<span class="col-md-5" id="priceSpan">*</span>
						</div>
						<div class="form-group" id="iidDiv">
							<!-- 定义表单提示文字 -->
							<label class="col-md-2 control-label" for="iid">所属类别：</label>
							<div class="col-md-5">
								<select id="iid" name="iid" class="form-control">
									<option value="">====== 请选择商品的所属分类 ======</option>
									<c:forEach items="${allItems}" var="item">
										<option value="${item.iid}" ${item.iid==goods.iid?"selected":""}>${item.title}</option>
									</c:forEach>
								</select>
							</div>
							<!-- 定义表单错误提示显示元素 -->
							<div class="col-md-5" id="iidMsg">*</div>
						</div>
						<div class="form-group" id="sidDiv">
							<!-- 定义表单提示文字 -->
							<label class="col-md-2 control-label" for="sid">所属子类别：</label>
							<div class="col-md-5">
								<select id="sid" name="sid" class="form-control">
									<option value="">====== 请选择商品的所属子分类 ======</option>
									<c:forEach items="${allSubitems}" var="subitem">
										<option value="${subitem.sid}" ${subitem.sid==goods.sid?"selected":""}>${subitem.title}</option>
									</c:forEach>
								</select>
							</div>
							<!-- 定义表单错误提示显示元素 -->
							<div class="col-md-5" id="sidMsg">*</div>
						</div>
						<div class="form-group" id="picDiv">
							<label class="col-md-2 control-label" for="photo">商品图片：</label>
							<div class="col-md-5">
								<img src="upload/goods/${goods.photo}"><br>
								<input type="file" id="pic" name="pic" class="form-control" placeholder="请选择商品宣传图">
							</div>
							<span class="col-md-5" id="picSpan">如果不修改可以不选择</span>
						</div>
						<div class="form-group">
							<div class="col-md-3 col-md-offset-3">
								<input type="hidden" id="gid" name="gid" value="${goods.gid}">
								<input type="hidden" id="photo" name="photo" value="${goods.photo}">
								<input type="submit" value="提交" class="btn btn-primary">
								<input type="reset" value="重置" class="btn btn-warning">
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>