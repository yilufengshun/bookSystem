<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'page.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
  </head>
  
  <body>
 <p style="background: red;"> ${msg }</p>
    <table width="100%" border="1">
    		<tr>
    		<td>图书名称</td>
    		<td>作者</td>
    		<td>出版社</td>
    		<td>库存</td>
    		<td>操作</td>
    		</tr>
    		<c:if test="${empty page.data }">
    		<h1>没有查询到数据</h1>
    		</c:if>
    		
    		
    		
    	<c:forEach items="${page.data }" var="item" varStatus="vs">
    		<tr>
    		<td>${item.bookName }</td>
    		<td>${item.author }</td>
    		<td>${item.publisher }</td>
    		<td>${item.count }</td>
    		<td><a href="findBookById?bookid=${item.bookid }">详情
    		<a href="edit.jsp?bookid=${item.bookid }">修改
    		<a href="javascript:void(0)"  onclick="del(${item.bookid})" >删除</td>
    		</tr>
    </c:forEach>
    
 
    
    </table>
    <a href="findByName?pageindex=${pageindex-1 }&bookName=${bookName}&typeid=${typeid}">【上一页】</a>
    <c:forEach begin="${page.startIndex }" end="${page.endIndex }" var="it" varStatus="vs">
    <a href="findByName?pageindex=${it }&bookName=${bookName}&typeid=${typeid}" style="${pageindex==it?'background: red;':''} "> ${it } </a>	
   
    <!--     这里需要注意将查询的参数传过来，不然翻页会自动查询所有的 -->
    </c:forEach>
     <a href="findByName?pageindex=${pageindex+1 }&bookName=${bookName}&typeid=${typeid}">【下一页】</a>
  </body>
  <script type="text/javascript">
  	function del(id){
  	  //使用ajax实现删除操作，然后直接更新iframe
  	
  		if(confirm("确定删除吗？")){
  			$.ajax({
				type:"get",
				url:"deleteBookById?bookid="+id,
				async:true,
				success:function(result){
				alert(result);	
				window.location.href='findByName';
				}
				});
  		
  		}
  
  }
  </script>
  
  
</html>
