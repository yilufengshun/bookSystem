package com.meng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.meng.dao.BookTypeDao;
import com.meng.domain.bookType;
import com.meng.utils.C3p0Utils;

public class BookTypeDapImpl implements BookTypeDao{

	@Override
	public List<bookType> findBookType() {
		QueryRunner qr=new QueryRunner(C3p0Utils.getDataSource());
		
		List<bookType> types = null;
		try {
			types = qr.query("select * from bookType",new BeanListHandler<bookType>(bookType.class));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		return types;
	}

}
