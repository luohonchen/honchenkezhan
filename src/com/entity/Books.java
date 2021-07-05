package com.entity;

import com.util.VeDate;

public class Books {
	private String booksid = "B" + VeDate.getStringId();
	private String usersid;
	private String booksname;
	private String image;
	private String bcateid;
	private String scateid;
	private String addtime;
	private String status;
	private String hits;
	private String contents;
	private String username;
	private String bcatename;
	private String scatename;

	public String getBooksid() {
		return booksid;
	}

	public void setBooksid(String booksid) {
		this.booksid = booksid;
	}

	public String getUsersid() {
		return usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getBooksname() {
		return this.booksname;
	}

	public void setBooksname(String booksname) {
		this.booksname = booksname;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBcateid() {
		return this.bcateid;
	}

	public void setBcateid(String bcateid) {
		this.bcateid = bcateid;
	}

	public String getScateid() {
		return this.scateid;
	}

	public void setScateid(String scateid) {
		this.scateid = scateid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHits() {
		return this.hits;
	}

	public void setHits(String hits) {
		this.hits = hits;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBcatename() {
		return this.bcatename;
	}

	public void setBcatename(String bcatename) {
		this.bcatename = bcatename;
	}

	public String getScatename() {
		return this.scatename;
	}

	public void setScatename(String scatename) {
		this.scatename = scatename;
	}
}
