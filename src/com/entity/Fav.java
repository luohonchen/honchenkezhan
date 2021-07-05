package com.entity;

import com.util.VeDate;

public class Fav {
	private String favid = "F" + VeDate.getStringId();
	private String usersid;
	private String booksid;
	private String addtime;
	private String username;
	private String booksname;

	public String getFavid() {
		return favid;
	}

	public void setFavid(String favid) {
		this.favid = favid;
	}

	public String getUsersid() {
		return this.usersid;
	}

	public void setUsersid(String usersid) {
		this.usersid = usersid;
	}

	public String getBooksid() {
		return this.booksid;
	}

	public void setBooksid(String booksid) {
		this.booksid = booksid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBooksname() {
		return this.booksname;
	}

	public void setBooksname(String booksname) {
		this.booksname = booksname;
	}
}
