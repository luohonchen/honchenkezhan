package com.entity;

import java.util.ArrayList;
import java.util.List;

import com.util.VeDate;

public class Bcate {
	private String bcateid = "B" + VeDate.getStringId();
	private String bcatename;
	private String memo;
	private List<Scate> scateList = new ArrayList<Scate>();
	private List<Books> booksList = new ArrayList<Books>();

	public List<Scate> getScateList() {
		return scateList;
	}

	public void setScateList(List<Scate> scateList) {
		this.scateList = scateList;
	}

	public List<Books> getBooksList() {
		return booksList;
	}

	public void setBooksList(List<Books> booksList) {
		this.booksList = booksList;
	}

	public String getBcateid() {
		return bcateid;
	}

	public void setBcateid(String bcateid) {
		this.bcateid = bcateid;
	}

	public String getBcatename() {
		return this.bcatename;
	}

	public void setBcatename(String bcatename) {
		this.bcatename = bcatename;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
