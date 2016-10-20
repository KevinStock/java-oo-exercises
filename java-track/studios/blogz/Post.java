package blogz;

import java.util.Date;

public class Post extends Entity {

	private String title;
	private String body;
	private String author;
	private final Date created;
	private Date modified;
	
	public Post(String title, String body) {
		super();
		this.title = title;
		this.body = body;
		created = new Date();
		modified = created;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified() {
		this.modified = new Date();
	}

	public Date getCreated() {
		return created;
	}
	
	public String toString() {
		return "UID: " + this.getUID() + 
				" Title: " + this.getTitle() + 
				" Body: " + this.getBody() + 
				" Created: " + this.getCreated() + 
				" Modified: " + this.getModified();
	}
	
	public static void main(String[] args) {
		// ...
	}
}
