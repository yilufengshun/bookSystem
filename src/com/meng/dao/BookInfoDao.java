package com.meng.dao;

import java.util.List;

import com.meng.domain.Page;
import com.meng.domain.bookInfo;

public interface BookInfoDao {
		public List<bookInfo> findBook();   //
		public bookInfo findBookById(int bookId);
		public List<bookInfo> findBookByName(String name,int typeId);
		public Page findBookByPage(int pageindex,String name,int typeId);  //根据查询的名字和类型查询分页
		public int getBookCount(String name,int typeId);
		public void editById(bookInfo book);    //修改书籍信息
		public void deleteBookById(int bookId);   // 删除信息
}
