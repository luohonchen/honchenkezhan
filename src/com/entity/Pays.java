package com.entity;

import com.util.VeDate;

public class Pays {
	private String paysid = "P" + VeDate.getStringId();
	private String usersid;
	private String booksid;
	private String sectionsid;
	private String money;
	private String addtime;
	private String username;
	private String booksname;
	private String title;

	public String getPaysid() {
		return paysid;
	}

	public void setPaysid(String paysid) {
		this.paysid = paysid;
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

	public String getSectionsid() {
		return this.sectionsid;
	}

	public void setSectionsid(String sectionsid) {
		this.sectionsid = sectionsid;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
