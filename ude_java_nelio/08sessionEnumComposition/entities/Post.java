package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
	
	// Dessa forma teremos apenas uma copia de SimpleDateFormat para toda a aplicação.
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

	private Date moment;
	private String title;
	private String content;
	private Integer likes;
	
	private List<Comment> comments = new ArrayList<Comment>();
	
	// Constructors
	public Post(Date moment, String title, String content, int likes) {	
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.likes = likes;
	}

	// Getters and Setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public List<Comment> getComments() {
		return comments;
	}
	
	public void addComment (Comment comment) {
		this.comments.add(comment);
	}
	
	public void removeComment (Comment comment) {
		this.comments.remove(comment);
	}
	
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.getTitle() + '\n');
		sb.append(this.getLikes());
		sb.append(" Likes - ");
		sb.append(this.sdf.format(this.getMoment()) + '\n');
		sb.append(this.getContent() + '\n');
		sb.append("Comments: \n");
		for (Comment c: comments) {
			sb.append(c.getText() + '\n');
		}
		return sb.toString();		
	}
}
