package com.model;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = -4409276818796140998L;

	public Result() {
		super();
	}

	public Result(String displayDate) {
		super();
		this.displayDate = displayDate;
	}

	private String displayDate;

	public String getDisplayDate() {
		return this.displayDate;
	}

	public void setDisplayDate(String displayDate) {
		this.displayDate = displayDate;
	}

}
