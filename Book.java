package A00books;
/**
 * Interface Class Book that will be implementing comparable 
 * The object and constructor will have three values: String title, String author, and int Year
 * @author Hai Le
 * 8/26/19
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable<Book>{

	//Create the three values String title, String author, and int year
	private String title;
	private String author;
	private int year;
	
	//Constructor that takes in 3 parameters for the 3 values of the book
	public Book(String title, String author, int year) {
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	//Create getters for each value of the object that return the value of corresponding stat
	
	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public int getYear() {
		return year;
	}

	//Implement the toString method that will output following form: name by author ( year )
	@Override
	public String toString() {
		return title + " by " + author + "(" + year + ")";
	}
	
	//Implement a static method called getList that will first read in the data from csv file, and add the book to the list,
	//and will output error message if the input does not follow intended algorhithm 
	public static List<Book> getList(String file) {
			List<Book> bookList = new ArrayList<Book>();
			//Create a new Scanner called reader that will read in a file in BookApp that will be passed in the form of a string through object file
			Scanner reader = new Scanner(BookApp.class.getResourceAsStream(file));
			String line;
			int nBooks = 0; //Counter to keep track of books
			while(reader.hasNextLine()) { //While the reader is still reading an upcoming line, go to the next line, and set the mountain object to the next line
				line = reader.nextLine();
				String[] bookDetails = line.split(","); //Find the correct format. A simple method to do this, is to split the line on commas (since it is a csv file), and check that it has at least 3 elements in the array.
				if (bookDetails.length < 3 || bookDetails.length > 3) { // If book details is = or greater than 3 AKA 3 commas AKA title,author,year, then output the error message also if it's bigger than 3    
					System.err.println("Problem reading in " + "" + line + "");
			    }
				else{ //Else increment nBooks by 1, and add new book to bookList with the 3 parameters of bookDetails index 0 1 and 2 
					nBooks = nBooks + 1;
					bookList.add(new Book(bookDetails[0], bookDetails[1], Integer.parseInt(bookDetails[2])));
				}
			}
				System.out.println("Numbers of books read in: " + nBooks); //Output numbers of books read in :
				System.out.println();
				System.out.println("Sorted book list: "); //Output the title sorted book list: 
				bookList.sort(null);//Sort the list in order
				for(int i = 0; i <= bookList.size()-1; i++) { //For loop to output every book using method get 
					System.out.println(bookList.get(i));
				}
				System.out.println();
				System.out.println("Reverse Order: ");
				for(int i = bookList.size() -1; i >= 0; i--) { //For loop to output every book using method get counting backwards for reverse order
					System.out.println(bookList.get(i));
				}
		 return bookList;
	}
	@Override
	public int compareTo(Book other) {
		//Compare the title of the book used as argument with the other book which is passed as parameter
		//This is necessary for sorting a list of books
		return String.CASE_INSENSITIVE_ORDER.compare(this.title, other.title);
	}
}
