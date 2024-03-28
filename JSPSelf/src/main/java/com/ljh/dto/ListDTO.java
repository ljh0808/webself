package com.ljh.dto;

import java.util.Date;

public class ListDTO {
	public String no;
	public String title;
	public String writer;
	public Date day ;
	public String count;
	public String content;
	
	public ListDTO(String title,String content) {
		this.title=title;
		this.content = content;
	}
	public ListDTO(String no,String title,String content) {
		this.no = no;
		this.title=title;
		this.content = content;
	}
	
	public ListDTO(String no,String title,String writer,Date day,String count){
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.day = day;
		this.count = count;
	}
	
	public ListDTO(String no,String title,String writer,Date day,String count
			,String content){
		this.no = no;
		this.title = title;
		this.writer = writer;
		this.day = day;
		this.count = count;
		this.content = content;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
