package com.meng.domain;

import java.util.List;



public class Page {
	//页码	
	private int pageIndex;
//页大小
	private int pageSize=10;
//总数据个数
	private int totalCount;
	private int startIndex;
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	private int endIndex;
	
	
	private int pageCount;
	private List<bookInfo> data;
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public List<bookInfo> getData() {
		return data;
	}
	public void setData(List<bookInfo> data) {
		this.data = data;
	}
	public Page(int pageIndex, int totalCount) {
		super();
		this.pageIndex = pageIndex;
		
		this.totalCount = totalCount;
	
		pageCount=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
		
		startIndex=pageIndex-5;
		endIndex=pageIndex+4;
		
		//特殊情
		if(pageIndex<=5)
		{
			startIndex=1;
			endIndex=9;
		}
		if(pageIndex>=pageCount-4){
			startIndex=pageCount-9;
			endIndex=pageCount;
		}
		if(startIndex<1)
			startIndex=1;
	}
	
	
}
