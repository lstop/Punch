<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Cache" content="no-cache">
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet"/>
 
<!-- 可选的Bootstrap主题文件（一般不使用） -->

 <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet"/>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
		<title></title>
	</head>

	<body>
	<div class="container">
	<div class="row">
		<div class="span2">
		</div>
		<div class="span6">
			<form class="form-horizontal" action="login" method="post" >
				<div class="control-group">
					<label class="control-label" for="inputEmail">用户名</label>
					<div class="controls">
						<input id="inputEmail" type="text" name="username"/>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input id="inputPassword" type="password" name="pwd"/>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<button class="btn" type="submit">登陆</button>
					</div>
				</div>
			</form>
		</div>
		<div class="span4">
		</div>
	</div>
</div>
	</body>

</html>