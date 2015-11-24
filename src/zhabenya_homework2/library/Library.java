package zhabenya_homework2.library;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Library {

    Scanner scanner = new Scanner(System.in);
    Librarian librarian1;
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Reader> readers = new ArrayList<>();

    protected void createLibrarian(String name, String username){
        librarian1 = new Librarian(name, username);
    }

    protected void createReader(String name, String username){
        readers.add(new Reader(name, username));
    }

    public void start(){

        login();

        /*System.out.println("Welcome to My Library! \n" +
                "Who are you?\n" +
                "1. Librarian\n" +
                "2. Reader");
        int choice1 = scanner.nextInt();
        switch (choice1){
            case 1: login();
                break;
            case 2: login();
                break;
            default:
                System.out.println("Sorry, we don't have this option. Try again!");
                start();
        }*/

    }

    public User login(){
        System.out.println("Enter your username:");
        String username = scanner.next();
        System.out.println("Enter your password:");
        int pass = scanner.nextInt();

        if (username.equals(librarian1.getName()) && pass == librarian1.getPass()){
            return librarian1;
        } else {
            for (int i = 0; i < readers.size(); i++) {
                if (readers.equals.us
            }

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
