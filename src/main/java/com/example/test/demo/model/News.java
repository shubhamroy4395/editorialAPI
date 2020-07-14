package com.example.test.demo.model;

public class News {

	private String title;
	private String article;
	private String publishDate;
	private String newspaperName;
	public String getNewspaperName() {
		return newspaperName;
	}
	public void setNewspaperName(String newspaperName) {
		this.newspaperName = newspaperName;
	}
	public News(String newspaperName,String title, String article, String publishDate) {
		super();
		this.title = title;
		this.article = article;
		this.publishDate = publishDate;
		this.newspaperName = newspaperName;
	}
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	@Override
	public String toString() {
		return "News [title=" + title + ", article=" + article + ", publishDate=" + publishDate + "]";
	}
	
	
}
