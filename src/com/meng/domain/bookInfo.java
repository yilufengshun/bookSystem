package com.meng.domain;

import java.util.Date;

public class bookInfo {
		private int bookid;
		private  String bookName;
		private  bookType type;
		private  String Author;
		private  String Publisher;
		private  Date publishTime;
		private  int Count;
		private String Remark;
		private int typeId;
		public String getRemark() {
			return Remark;
		}
		public void setRemark(String Remark) {
			this.Remark = Remark;
		}
		public int getBookid() {
			return bookid;
		}
		public void setBookid(int bookid) {
			this.bookid = bookid;
		}
		public String getBookName() {
			return bookName;
		}
		public void setBookName(String bookName) {
			this.bookName = bookName;
		}
		public bookType getType() {
			return type;
		}
		public void setType(bookType type) {
			this.type = type;
		}
		public String getAuthor() {
			return Author;
		}
		public void setAuthor(String author) {
			this.Author = author;
		}
		public String getPublisher() {
			return Publisher;
		}
		public void setPublisher(String publisher) {
			this.Publisher = publisher;
		}
		public Date getPublishTime() {
			return publishTime;
		}
		public void setPublishTime(Date publishTime) {
			this.publishTime = publishTime;
		}
		public int getCount() {
			return Count;
		}
		public void setCount(int count) {
			this.Count = count;
		}
		
		public bookInfo(int bookid, String bookName, int typeId, String author, String publisher, Date publishTime,
				int count, String Remark) {
			super();
			this.bookid = bookid;
			this.bookName = bookName;
			this.typeId = typeId;
			this.Author = author;
			this.Publisher = publisher;
			this.publishTime = publishTime;
			this.Count = count;
			this.Remark = Remark;
		}
		public bookInfo() {
			super();
		}
		public int getTypeId() {
			return typeId;
		}
		public void setTypeId(int typeId) {
			this.typeId = typeId;
		}
		
		
}
