package com.meng.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.service.BookInfoService;
import com.meng.service.impl.BookInfoServiceImpl;

@WebServlet("/deleteBookById")
public class deleteBookById extends HttpServlet{
		//这是处理删除操作的类
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookid=req.getParameter("bookid");
		BookInfoService bs=new BookInfoServiceImpl();
		bs.deleteBookById(bookid);
		resp.getWriter().print("删除成功！");
	}
	
}
