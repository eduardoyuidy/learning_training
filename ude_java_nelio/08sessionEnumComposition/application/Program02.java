package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.Comment;
import entities.Post;

public class Program02 {

	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date dateFirstPost = sdf.parse("21/06/2018 13:05:44");
		
		Post firstPost = new Post(
							dateFirstPost, 
							"Travelling to New Zealand!!", 
							"I'm going to visit this wonderful country!", 
							12);
		
		firstPost.addComment(new Comment("Have a nice trip."));
		firstPost.addComment(new Comment("Wow that's awesome!"));
		
		Date dateSecondPost = sdf.parse("28/07/2018 23:14:19");
		
		Post secondPost = new Post(
							dateSecondPost, 
							"Good night guys", 
							"See you tomorrow!", 
							5);
		
		secondPost.addComment(new Comment("Good night!"));
		secondPost.addComment(new Comment("May the Force be with you!"));	
		
		System.out.println(firstPost);
		
		System.out.println(secondPost);
	}
}
