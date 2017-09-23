package com.meng.service;

import java.util.List;

import com.meng.domain.Page;
import com.meng.domain.bookInfo;

public interface BookInfoService {
		public List<bookInfo> findBook();
		public bookInfo findBookById(String id);
		public List<bookInfo> findBookByName(String name,int typeId);
		public Page findBookByPage(int pageindex, String name, int typeId);
		public void editById(bookInfo book);
		public void deleteBookById(String bookId);
}
