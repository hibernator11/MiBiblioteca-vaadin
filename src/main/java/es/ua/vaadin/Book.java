package es.ua.vaadin;

public class Book {

    String publication;
    String title;
    String author;
    
    public Book(String publication, String title, String author) {
    	this.publication = publication;
    	this.title = title;
    	this.author = author;
    }
    
	public String getPublication() {
		return publication;
	}
	public void setPublication(String publication) {
		this.publication = publication;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
