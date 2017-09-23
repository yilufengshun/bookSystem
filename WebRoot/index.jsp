<%@page import="com.meng.domain.bookType"%>
<%@page import="com.meng.service.impl.BookTypeServiceImpl"%>
<%@page import="com.meng.service.BookTypeService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图书查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%
		BookTypeService bs=new BookTypeServiceImpl();
		List<bookType> types=bs.findBookTypes();
		session.setAttribute("booktypes", types);
		
		
	 %>
	
	
  </head>
  
  <body style="width: 1000px">
  <form action="findByName" target="iframe">
   图书名称:
   <input type="text"  name="bookName"/>
   图书类别：
   <select name="typeid">
   			<option value="0">全部</option>
   	   		<c:forEach items="${ booktypes}" var="item" varStatus="vs">
  			<option value="${item.typeId }">${item.typeName }</option>
  			</c:forEach>
   </select>
   <input type="submit" value="查询" />
   <br/>
   
   
   <iframe src="page.jsp"  name="iframe" width="1000px" height="500px">
   
   
   </iframe>
   因为时间原因，所有代码均没有进行错误处理。
   <br>
   孟祥顺
   <br>
   JAVAEE1712
   <br>
   
   
   </form>
  </body>
</html>
