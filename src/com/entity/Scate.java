package com.entity;

import com.util.VeDate;

public class Scate {
	private String scateid = "S" + VeDate.getStringId();
	private String scatename;
	private String bcateid;
	private String memo;
	private String bcatename;

	public String getScateid() {
		return scateid;
	}

	public void setScateid(String scateid) {
		this.scateid = scateid;
	}

	public String getScatename() {
		return this.scatename;
	}

	public void setScatename(String scatename) {
		this.scatename = scatename;
	}

	public String getBcateid() {
		return this.bcateid;
	}

	public void setBcateid(String bcateid) {
		this.bcateid = bcateid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getBcatename() {
		return this.bcatename;
	}

	public void setBcatename(String bcatename) {
		this.bcatename = bcatename;
	}
}
