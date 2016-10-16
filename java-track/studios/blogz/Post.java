package blogz;

import java.util.Date;

public class Post {

	private String title;
	private String body;
	private String author;
	private final Date created;
	private Date modified;
	
	public Post(String title, String body) {
		this.title = title;
		this.body = body;
		created = new Date();
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

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getCreated() {
		return created;
	}
	
	
}
