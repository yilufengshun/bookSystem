<%@page import="com.meng.domain.bookInfo"%>
<%@page import="com.meng.service.impl.BookInfoServiceImpl"%>
<%@page import="com.meng.service.BookInfoService"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<%
	String id=request.getParameter("bookid");
	BookInfoService bs=new BookInfoServiceImpl();
	bookInfo book=bs.findBookById(id);
	session.setAttribute("book", book);

 %>

  </head>
  
  <body>
    <h2>修改信息</h2>
    <form action="editBookById">
    <table>
    <tr>
    	<td>书号：</td>
    	<td><input type="text" name="bookId" value="${book.bookid }" readonly="readonly"></td>
    </tr>
    <tr>
    	<td>书名：</td>
    	<td><input type="text" name="bookName" value="${book.bookName }"></td>
    </tr>
      <tr>
    	<td>类型：</td>
    	<td><input type="text"  naem="typeId" value="${book.typeId }" readonly="readonly"></td>
    </tr>
      <tr>
    	<td>作者：</td>
    	<td><input type="text" name="Author" value="${book.author }"></td>
    </tr>
      <tr>
    	<td>出版社：</td>
    	<td><input type="text" name="Publisher" value="${book.publisher }"></td>
    </tr>
      <tr>
    	<td>出版时间：</td>
    	<td><input type="text" name="publishTime" value="${book.publishTime }" readonly="readonly"></td>
    </tr>
      <tr>
    	<td>库存：</td>
    	<td><input type="text" name="Count" value="${book.count }"></td>
    </tr>
     <tr>
    	<td>库存：</td>
    	<td><textarea rows="" cols="" name="Remark" value="${book.remark }"></textarea></td>
    </tr>
    <tr>
    <td><input type="submit" value="提交修改"></td>
    <td><a href="index.jsp">返回</a></td>
    </tr>
    
    </table>
    
    
    </form>
  </body>
</html>
