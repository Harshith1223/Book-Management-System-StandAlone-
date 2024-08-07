package BookManagement;

import java.util.Scanner;
import java.util.regex.Pattern;

public class validator {
	public static final String RED="\u001B[31m";
	public static final String RESET="\u001B[0m";
	private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
	private static Pattern AuthorTitle_Pattern= Pattern.compile("^[a-zA-Z]+$");
	private static Pattern PublishYear_Pattern= Pattern.compile("^\\d{4}$");
	Scanner sc=new Scanner(System.in);
	
	public String validateId() {
		String bookid;
		while(true) {
			System.out.println("Enter the ID");
			bookid=sc.nextLine();
			if(!ID_PATTERN.matcher(bookid).matches()) { // also can use--> if(!Pattern.matches(ID_PATTERN,bookid)
				System.out.println(RED+"PLEASE ENTER VALID BOOK ID"+RESET);
			}
			else {
				break;
			}
		}
		return bookid;
	}
	
	public String validateAuthorTitle(String input) {
		String res;
		while(true) {
			if(input=="TITLE") {
				System.out.println("Enter the Title");
			}
			else {
				System.out.println("Enter Author name");
			}
			res=sc.nextLine();
			if(!AuthorTitle_Pattern.matcher(res).matches()) {
				System.out.println(RED+"Enter a valid "+input+RESET);
			}
			else
			{
				break;
			}
		}
		return res;
	}
	
	public String validatePublishYear() {
		String year;
		while(true) {
			System.out.println("Enter the publish year of the Book");
			year=sc.nextLine();
			if(!PublishYear_Pattern.matcher(year).matches()) {
				System.out.println(RED+"! Enter a Valid year"+RESET);
			}
			else {
				break;
			}
		}
		return year;
	}
	
}
