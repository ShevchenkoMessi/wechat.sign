package com.xt.wechat.sign.manager.entity;

import java.io.Serializable;

public class Announcement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2319138054962206L;

	private Integer id;
	
	private String item;
	
	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Announcement [id=" + id + ", item=" + item + ", text=" + text + "]";
	}

}
