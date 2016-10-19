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
	
	public static void main(String[] args) {
		Post p = new Post("First", "1st Post");
		System.out.println(p.getTitle() + "\n" + p.getBody() + "\n" + p.getCreated() + "\n" + p.getModified());
	}
}
