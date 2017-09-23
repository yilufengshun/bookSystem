package com.meng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.meng.dao.BookInfoDao;
import com.meng.domain.Page;
import com.meng.domain.bookInfo;
import com.meng.utils.C3p0Utils;
import com.sun.org.apache.bcel.internal.generic.NEW;


public class BookInfoDaoImpl implements BookInfoDao{

	@Override
	public List<bookInfo> findBook() {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());
		
	List<bookInfo> books = null;
	try {
		books = qr.query("select * from bookInfo ",new BeanListHandler<bookInfo>(bookInfo.class));
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return books;
	}

	@Override
	public bookInfo findBookById(int bookId) {
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());
		
		bookInfo book = null;
		try {
			book = qr.query("select * from bookInfo where bookId=?",new BeanHandler<bookInfo>(bookInfo.class),bookId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return book;
	}

	@Override
	public List<bookInfo> findBookByName(String name,int typeId) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());
		
	List<bookInfo> books = null;
	String sql="select * from bookInfo ";
	try {
		if(name.trim().equals("")){
			if(typeId==0)
			books = qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class));
			else {
				sql+=" where typeId=?";
				books = qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),typeId);
			}
		}else{
		if(typeId!=0){
			
			
			sql+=" where   bookName like  ? and typeid= ?";
			books = qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),"%"+name+"%",typeId);
		
		}else {
			sql+=" bookName like ?";
			books = qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),"%"+name+"%");
		}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	return books;
	}

	@Override
	public Page findBookByPage(int pageindex,  String name, int typeId) {
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());
		int totalCount = getBookCount(name, typeId);
		Page page=new Page(pageindex, totalCount);
		int pagesize=page.getPageSize();
		int begin=(pageindex-1)*pagesize;
		int end=pagesize;
		
		String sql="select * from bookInfo ";
		List<bookInfo> books=null;
		try {
			if(name==null||name.trim().equals("")){
				if(typeId==0){
					sql+=" limit ?,?";
				books = qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),begin,end);
				}
				else {
					sql+=" where typeId=? limit ?,?";
					books = qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),typeId,begin,end);
				}
			}else{
			if(typeId!=0){
				
				
				sql+=" where   bookName like  ? and typeid= ? limit ?,?";
				books =  qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),"%"+name+"%",typeId,begin,end);
			
			}else {
				sql+=" where bookName like ? limit ?,?";
				books =  qr.query(sql,new BeanListHandler<bookInfo>(bookInfo.class),"%"+name+"%",begin,end);
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
		page.setData(books);
		return page;
		

	}

	@Override
	public int getBookCount(String name,int typeId) {
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());

		String sql="select count(*) from bookInfo ";
		long books=0;
		try {
			if(name==null||name.trim().equals("")){
				if(typeId==0)
				books = (long)qr.query(sql,new ScalarHandler(1));
				else {
					sql+=" where typeId=?";
					books = (long) qr.query(sql,new ScalarHandler(1),typeId);
				}
			}else{
			if(typeId!=0){
				
				
				sql+=" where   bookName like  ? and typeid= ?";
				books = (long) qr.query(sql,new ScalarHandler(1),"%"+name+"%",typeId);
			
			}else {
				sql+=" where bookName like ?";
				books = (long) qr.query(sql,new ScalarHandler(1),"%"+name+"%");
			}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		return (int) books;
	}

	@Override
	public void editById(bookInfo book) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());
		bookInfo rebook=null;
		String sql="update bookInfo set bookName=?,typeId=?,Author=?,Publisher=?,Count=?,Remark=? where bookId=?";
		try {
			 qr.update(sql,book.getBookName(),book.getTypeId(),book.getAuthor(),book.getPublisher(),book.getCount(),book.getRemark(),book.getBookid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void deleteBookById(int bookId) {
		// TODO Auto-generated method stub
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());
		try {
			qr.update("delete from bookInfo where bookId=?",bookId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
