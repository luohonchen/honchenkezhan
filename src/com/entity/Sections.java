package com.entity;

import com.util.VeDate;

public class Sections {
	private String sectionsid = "S" + VeDate.getStringId();
	private String booksid;
	private String title;
	private String contents;
	private String addtime;
	private String hits;
	private String cate;
	private String thepre;
	private String thenxt;
	private String booksname;

	public String getSectionsid() {
		return sectionsid;
	}

	public void setSectionsid(String sectionsid) {
		this.sectionsid = sectionsid;
	}

	public String getBooksid() {
		return this.booksid;
	}

	public void setBooksid(String booksid) {
		this.booksid = booksid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getCate() {
		return this.cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getThepre() {
		return this.thepre;
	}

	public void setThepre(String thepre) {
		this.thepre = thepre;
	}

	public String getThenxt() {
		return this.thenxt;
	}

	public void setThenxt(String thenxt) {
		this.thenxt = thenxt;
	}

	public String getBooksname() {
		return this.booksname;
	}

	public void setBooksname(String booksname) {
		this.booksname = booksname;
	}
}
