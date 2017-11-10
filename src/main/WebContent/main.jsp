<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!-- 新 Bootstrap 核心 CSS 文件 -->
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet" />
		<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/list.js"></script>
		<!-- 可选的Bootstrap主题文件（一般不使用） -->

		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.css" rel="stylesheet" />
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.js"></script>
		<title></title>
		<style type="text/css" media="screen">
			#pagination-digg li {
				border: 0;
				margin: 0;
				padding: 0;
				font-size: 11px;
				list-style: none;
				/* savers */
				float: left;
			}
			
			#pagination-digg a {
				border: solid 1px #9aafe5;
				margin-right: 2px;
			}
			
			#pagination-digg .previous-off,
			#pagination-digg .next-off {
				border: solid 1px #DEDEDE;
				color: #888888;
				display: block;
				float: left;
				font-weight: bold;
				margin-right: 2px;
				padding: 3px 4px;
			}
			
			#pagination-digg .next a,
			#pagination-digg .previous a {
				font-weight: bold;
			}
			
			#pagination-digg .active {
				background: #2e6ab1;
				color: #FFFFFF;
				font-weight: bold;
				display: block;
				float: left;
				padding: 4px 6px;
				/* savers */
				margin-right: 2px;
			}
			
			#pagination-digg a:link,
			#pagination-digg a:visited {
				color: #0e509e;
				display: block;
				float: left;
				padding: 3px 6px;
				text-decoration: none;
			}
			
			#pagination-digg a:hover {
				border: solid 1px #0e509e;
			}
			
			body {
				font-family: Arial, Helvetica, sans-serif;
				font-size: 12px;
			}
			
			h2 {
				clear: both;
				border: 0;
				margin: 0;
				padding-top: 30px;
				font-size: 13px;
			}
			
			p {
				border: 0;
				margin: 0;
				padding: 0;
				padding-bottom: 20px;
			}
			
			ul {
				border: 0;
				margin: 0;
				padding: 0;
			}
		</style>
		<script>
			$(document).ready(function(){
				if($("#levelhide").val()==1){
					$("#check").hide();
				}
				else{
					$("#check").show();
				}
				if($("#levelhide").val()==3){
					$("#search").hide();
					$("#subsearch").hide();
				}
				else{
					$("#search").show();
					$("#subsearch").show();
				}
				$("#check").click(function(){
					window.location.href="check?username=${user.username}";
				});
				$(".delete").click(function(){
					window.location.href="delete?level="+$("#levelhide").val()+"&delid="+$(this).attr("id");
				});
			});
		</script>
	</head>

	<body>
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<h3>
				欢迎你:${user.username}
				<input type="hidden" id="levelhide" value="${user.level }">
			</h3> <button class="btn btn-block btn-info" type="button" id="check">签到/打卡</button>
			<form action="searchlist" method="post"><input type="text" class="search" name="search" id="search" placeholder="根据员工名字插叙某一个员工的打卡记录" value="${search }"> <input id="subsearch" type="submit" value="提交"></form>

					<table class="table table-bordered">
						<thead>
							<tr>
								<th>
									员工
								</th>
								<th>
									打卡时间
								</th>
								<th>
									状态
								</th>
								<th>
								</th>
							</tr>
						</thead>
						<tbody>
						<!--success error warning info-->
						<c:forEach items="${userchecks}" var="userchecks">
							<tr>
								<td>
									${userchecks.uname }
								</td>
								<td>
									${userchecks.checktime }
								</td>
								<td>
									${userchecks.status }
								</td>
								<td>
									<a href="#" class="delete" id="${userchecks.id }">删除</a>
								</td>
							</tr>
						</c:forEach>
						<tr
						style="FONT-WEIGHT: normal; FONT-STYLE: normal; BACKGROUND-COLOR: white; TEXT-DECORATION: none">
						<TD colspan="7"><SPAN id="pagelink">
						<span class="pagination-buttons"> 
							<input type="hidden" id="pagehide" value="${pagehide }"> 
							<input type="hidden" id="perpagehide" value="${perpagehide }">
							<input type="hidden" id="sizehide" value="${sizehide }">
							<button type="button" id="previous" name="page" value="previous" class="button_prev">Previous</button>
							<button type="button" id="1" name="page" value="1" class="button_page">1</button>
							<button type="button" id="2" name="page" value="2" class="button_page">2</button>
							<button type="button" id="3" name="page" value="3" class="button_page">3</button>
							<button type="button" id="4" name="page" value="4" class="button_page">4</button>
							<button type="button" id="5" name="page" value="5" class="button_page">5</button>
							<button type="button" id="next" name="page" value="next" class="button_next">Next</button>

						</span>

						</SPAN></TD>
					</tr>
						</tbody>
					</table>

				</div>

			</div>
		</div>

	</body>

</html>