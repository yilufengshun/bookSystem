package com.meng.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.domain.bookInfo;
import com.meng.service.BookInfoService;
import com.meng.service.impl.BookInfoServiceImpl;

@WebServlet("/editBookById")
public class editBookById extends HttpServlet{
	//这是处理修改的程序
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookId=req.getParameter("bookId");
		String bookName=req.getParameter("bookName");
		String typeId=req.getParameter("typeId");
		String Author=req.getParameter("Author");
		String Publisher=req.getParameter("Publisher");
		String Count=req.getParameter("Count");
		String Remark=req.getParameter("Remark");
		bookInfo book=(bookInfo) req.getSession().getAttribute("book");
		try {
			book.setAuthor(Author);
			book.setBookName(bookName);
			book.setPublisher(Publisher);
			book.setCount(Integer.parseInt(Count));
			book.setRemark(Remark);
			BookInfoService bs=new BookInfoServiceImpl();
			bs.editById(book);
			req.setAttribute("msg", "修改成功");
			req.getRequestDispatcher("page.jsp").forward(req, resp);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			req.setAttribute("msg", "修改失败");
			req.getRequestDispatcher("page.jsp").forward(req, resp);
		}
		
		
	}
	
}
