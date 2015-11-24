package zhabenya_homework2.library;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Library {

    Scanner scanner = new Scanner(System.in);

    ArrayList<Book> books = new ArrayList<>();

    Librarian librarian1 = new Librarian();
    ArrayList<Reader> readers = new ArrayList<>();

    public void start(){

        System.out.println("Welcome to My Library! \n" +
                "Who are you?\n" +
                "1. Librarian\n" +
                "2. Reader");
        int choice1 = scanner.nextInt();
        switch (choice1){
            case 1: Librarian.login();
                break;
            case 2: Reader.showReaderOptions();
                break;
            default:
                System.out.println("Sorry, we don't have this option. Try again!");
                start();
        }

    }



    public void addBookManually(){
        System.out.println("Enter new book info");
        System.out.println("Book name");
        String name = scanner.next();
        System.out.println("Book author");
        String author = scanner.next();
        System.out.println("Year edition");
        int year = scanner.nextInt();
        books.add(new Book(name, author, year));
        System.out.println();
    }

    public Book addBook(String name, String author, int year){

    }

    public void showAvailableBooks(){

    }

    public void addReader
}
