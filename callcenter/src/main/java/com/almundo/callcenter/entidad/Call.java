package com.almundo.callcenter.entidad;

import java.io.Serializable;

public class Call implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3402746655884233004L;
	private String id;
	private String from;
	private String suject;
	
	public Call() {}
	
	public Call(String id, String from, String suject) {
		super();
		this.id = id;
		this.from = from;
		this.suject = suject;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSuject() {
		return suject;
	}
	public void setSuject(String suject) {
		this.suject = suject;
	}
	
	
}
