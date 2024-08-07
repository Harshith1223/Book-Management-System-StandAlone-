package BookManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookServiceImplementation implements BookserviceInterface{
	public static final String RED="\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String BLUE = "\u001B[34m";
	public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String CYAN = "\u001B[36m";
	
	Scanner sc=new Scanner(System.in);
	validator val=new validator();
	List<Book> books=new ArrayList<Book>();
	
	
	
	@Override
	public void addBook() {
		String bookid=val.validateId();
		String Author=val.validateAuthorTitle("AUTHOR");
		String Title=val.validateAuthorTitle("TITLE");
		String year=val.validatePublishYear();
		Book book=new Book(bookid,Author,Title,year,"Available");
		books.add(book);
		System.out.println(GREEN+"Book Added Successfully !!!"+RESET);
	}

	@Override
	public void showAllBooks() {
		boolean flag=true;
		System.out.println("\n---------------------------------------------------------------------");
		System.out.format(CYAN+"%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS"+RESET);
		System.out.println("\n---------------------------------------------------------------------");
		
		for(Book book:books) {
			System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishyear(),book.getStatus());
			System.out.println();
			flag=true;
		}
		System.out.println("\n---------------------------------------------------------------------");
		
		if(flag==false) {	
			System.out.println(RED+"THERE ARE NO BOOKS AVAILABLE IN THE LIBRARY"+RESET);
		}
	}

	@Override
	public void showAllAvailableBooks() {
		boolean flag=true;
		System.out.println("\n---------------------------------------------------------------------");
		System.out.format(CYAN+"%s%15s%15s%15s%15s","ID","TITLE","AUTHOR","PUBLISH YEAR","STATUS"+RESET);
		System.out.println("\n---------------------------------------------------------------------");
		
		
		if(books.size()>0) {
			for(Book book:books) {
				if(book.getStatus()=="Available") {
			System.out.format("%s%15s%15s%15s%15s",book.getId(),book.getTitle(),book.getAuthor(),book.getPublishyear(),book.getStatus());
			System.out.println();
			flag=true;
				}
			}
		}
		else{	
			System.out.println(RED+"THERE ARE NO BOOKS AVAILABLE IN THE LIBRARY"+RESET);
		}
		System.out.println("\n---------------------------------------------------------------------");
		if(flag==false) {
			System.out.println(RED+"THERE ARE NO BOOKS AVAILABLE IN THE LIBRARY WITH STATUS AVAILABLE"+RESET);
		}
	}

	@Override
	public void borrowBook() {
		String bookid=val.validateId();
		boolean flag=false;
		for(Book book : books) {
			if(book.getId().equals(bookid) && book.getStatus().equals("Available")) {
				flag=true;
				System.out.println(GREEN+"Book borrowed Successfully !!!"+RESET);
				book.setStatus("Not Available");
				System.out.println("Book borrowed details->"+book);
			}
		}
		if(flag==false) {
			System.out.println(RED+"The Book is not Available to Borrow"+RESET);
		}
	}

	@Override
	public void returnBook() {
		String bookid=val.validateId();
		boolean flag=false;
		for(Book book : books) {
			if(book.getId().equals(bookid) && book.getStatus().equals("Not Available")) {
				flag=true;
				System.out.println(GREEN+"Book returned Successfully !!!"+RESET);
				book.setStatus("Available");
				System.out.println("Book returned details->"+book);
			}
		}
		if(flag==false) {
			System.out.println(RED+"The Book is already Available cant Return it!!!"+RESET);
		}
	}

}
