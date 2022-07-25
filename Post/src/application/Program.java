package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Comment;
import entities.Post;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.print("Enter the title: ");
		String title = sc.nextLine();
		System.out.print("Enter the content:");
		String content = sc.nextLine();
		Post post = new Post(date, title, content, 0);
		boolean cond = true;
		while (cond) {
			System.out.printf("What you want to do?\n");
			System.out.println("1- Like\n2- Dislike\n3- Add Comment\n4- Nothing");
			int decision = sc.nextInt();
			switch (decision) {
			case 1:
				post.addLikes(1);
				break;
			case 2:
				post.removeLikes(1);
				break;
			case 3:
				System.out.printf("Insert your comment: ");
				sc.nextLine();
				String comment = sc.nextLine();
				Comment x = new Comment(comment);
				post.addComment(x);
				break;
			case 4:
				cond = false;
				break;
			default:
				System.out.println("Please insert a value option!");
				break;
			}
		}
		System.out.println();
		System.out.println(post);
		sc.close();
	}

}
