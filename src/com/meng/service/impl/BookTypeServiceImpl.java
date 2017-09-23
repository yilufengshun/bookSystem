package com.meng.service.impl;

import java.util.List;

import com.meng.dao.BookTypeDao;
import com.meng.dao.impl.BookTypeDapImpl;
import com.meng.domain.bookType;
import com.meng.service.BookTypeService;

public class BookTypeServiceImpl implements BookTypeService{

	@Override
	public List<bookType> findBookTypes() {
		// TODO Auto-generated method stub
		BookTypeDao bd=new BookTypeDapImpl();
		return bd.findBookType();
	}

}
