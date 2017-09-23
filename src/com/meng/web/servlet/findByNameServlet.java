package com.meng.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meng.domain.Page;
import com.meng.domain.bookInfo;
import com.meng.service.BookInfoService;
import com.meng.service.impl.BookInfoServiceImpl;


@WebServlet("/findByName")
public class findByNameServlet extends HttpServlet{
	//这是根据名字和类型，和页数进行查询的程序，大多数的处理都会转到本页实现数据的刷新
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doPost(req, resp);
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		String name=req.getParameter("bookName");	
		String typeid=req.getParameter("typeid");
		String pageindex=req.getParameter("pageindex");
		if(pageindex==null||pageindex.trim().equals("")||Integer.parseInt(pageindex)<=0)
			pageindex="1";
		
		if(typeid==null||typeid.trim().equals(""))
			typeid="0";
		BookInfoService bs=new BookInfoServiceImpl();
		Page page=bs.findBookByPage(Integer.parseInt(pageindex), name, Integer.parseInt(typeid));
		//List<bookInfo> books = bs.findBookByName(name, Integer.parseInt(typeid));
		req.getSession().setAttribute("bookName", name);
		req.getSession().setAttribute("typeid", typeid);
		req.setAttribute("page", page);
		req.setAttribute("pageindex", pageindex);
	//	req.setAttribute("page", books);
		req.getRequestDispatcher("page.jsp").forward(req, resp);
			
		}
	
	
}
