<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bookinfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <h1 style="color: blue;">${book.bookName }</h1>
  <table>
  	<tr>
  	<td>作者：</td>
  	<td>${book.author }</td>
  	</tr>
  	<tr>
  	<td>库存：</td>
  	<td>${book.count }</td>
  	</tr>
  	<tr>
  	<td>出版社：</td>
  	<td>${book.publisher }</td>
  	</tr>
  	<tr>
  	<td>出版时间：</td>
  	<td>${book.publishTime }</td>
  	</tr>
  	<tr>
  	<td>备注：</td>
  	<td>${book.remark }</td>
  	</tr>
  	
  </table>
  <a  href="findByName?bookName=${bookName }&typeid=${typeid}">返回</a>
 <br>
 <br>
 其中，书号，类型，出版日期不可修改。
  <body>
  <script type="text/javascript">
  	
  
  </script>
  </body>
</html>
