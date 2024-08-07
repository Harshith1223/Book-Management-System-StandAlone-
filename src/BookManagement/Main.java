package BookManagement;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BookserviceInterface service=new BookServiceImplementation();
		
		do {
			System.out.println("WELCOME TO THE BOOK MANAGEMENT SYSTEM");
			System.out.println("1.Add Book\n"+
								"2.Show All Books\n"+
								"3.Show All Available Books\n"+
								"4.Borrow Books\n"+
								"5.Return Books\n"+
								"6.Exit");
			
			System.out.println("ENTER YOUR CHOICE");
			int n=sc.nextInt();
			
			switch(n) {
			case 1:
				service.addBook();
				break;
				
			case 2:
				service.showAllBooks();
				break;
				
			case 3:
				service.showAllAvailableBooks();
				break;
				
			case 4:
				service.borrowBook();
				break;
				
			case 5:
				service.returnBook();
				break;
				
			case 6:
				System.out.println("Thank you");
				System.exit(0);
				break;
			
			default:
				System.out.println("Enter a valid Choice !!!!!!!!!!");
			}
		}
		while(true);
	}

}
