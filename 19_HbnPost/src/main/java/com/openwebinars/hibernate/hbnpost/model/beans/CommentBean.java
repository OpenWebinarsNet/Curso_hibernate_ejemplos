package com.openwebinars.hibernate.hbnpost.model.beans;

public class CommentBean {
	
	private String contenido;
	
	private long post_id;
	
	public CommentBean() {
		
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public long getPost_id() {
		return post_id;
	}

	public void setPost_id(long post_id) {
		this.post_id = post_id;
	}
	
	

}
