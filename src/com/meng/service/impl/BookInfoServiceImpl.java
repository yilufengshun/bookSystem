package com.meng.service.impl;

import java.util.List;

import com.meng.dao.BookInfoDao;
import com.meng.dao.impl.BookInfoDaoImpl;
import com.meng.domain.Page;
import com.meng.domain.bookInfo;
import com.meng.service.BookInfoService;

public class BookInfoServiceImpl implements BookInfoService{

	@Override
	public List<bookInfo> findBook() {
		// TODO Auto-generated method stub
		BookInfoDao bd=new BookInfoDaoImpl();
		
		return bd.findBook();
	}

	@Override
	public bookInfo findBookById(String id) {
		// TODO Auto-generated method stub
			BookInfoDao bd=new BookInfoDaoImpl();
		
		return bd.findBookById(Integer.parseInt(id));
		
	}

	@Override
	public List<bookInfo> findBookByName(String name,int typeId) {
			BookInfoDao bd=new BookInfoDaoImpl();
		
		return bd.findBookByName(name,typeId);
	}

	@Override
	public Page findBookByPage(int pageindex, String name, int typeId) {
		BookInfoDao bd=new BookInfoDaoImpl();
		return bd.findBookByPage(pageindex, name, typeId);
	}

	@Override
	public void editById(bookInfo book) {
		BookInfoDao bd=new BookInfoDaoImpl();
		bd.editById(book);
		return;
	}

	@Override
	public void deleteBookById(String bookId) {
		// TODO Auto-generated method stub
		BookInfoDao bd=new BookInfoDaoImpl();
		bd.deleteBookById(Integer.parseInt(bookId));
		
	}
}
