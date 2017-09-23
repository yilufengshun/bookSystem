package com.meng.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableServer.POA;

import com.meng.domain.bookInfo;
import com.meng.service.BookInfoService;
import com.meng.service.impl.BookInfoServiceImpl;

@WebServlet("/findBookById")
public class findBookByIdServlet extends HttpServlet{
	//这是通过id查找数据，也就是详情页面
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
			bookInfo book = bs.findBookById(bookid);
			req.setAttribute("book", book);
			req.getRequestDispatcher("bookinfo.jsp").forward(req, resp);
			
			
		}

}
