package com.example.test.demo.model;

public class HelloBean {
	String title;
	String article;
	String newspaper;
	String publishDate;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getNewspaper() {
		return newspaper;
	}
	public void setNewspaper(String newspaper) {
		this.newspaper = newspaper;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public HelloBean(String title, String article, String newspaper, String publishDate) {
		super();
		this.title = title;
		this.article = article;
		this.newspaper = newspaper;
		this.publishDate = publishDate;
	}
	
	

}
