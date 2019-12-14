package A00books;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
 * Class BookApp that will implement Book.java and read in data from book.csv and
 * print the number of books that were read in, and sort the list the books in natural order then
 * print them, then sort them again in reverse order and print them.
 * The purpose is to practice lists, scanners, interface, and application of that interface 
 * Author: Hai Le
 * 8/26/19
 */
public class BookApp {

	public static void main(String[] args) {
		//Use the type Book and call the method getList with the string consisting the desired file's name in quotation marks
		Book.getList("books.csv");
	}
}
