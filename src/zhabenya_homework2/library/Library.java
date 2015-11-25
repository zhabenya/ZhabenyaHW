package zhabenya_homework2.library;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Library {

    Scanner scanner = new Scanner(System.in);
    Librarian librarian;
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<Reader> readers = new ArrayList<>();

    protected void createLibrarian(String name, String username){
        librarian = new Librarian(name, username);
    }

    protected void createReader(String name, String username, int pass){
        Reader newReader = new Reader(name, username);
        readers.add(newReader);
        newReader.setPass(pass);
    }

    protected void enter(){
        User loggedUser = login();
        if (loggedUser instanceof Reader) {

            Reader loggedReader = (Reader) loggedUser;

        } else if (loggedUser instanceof Librarian){

            librarian = (Librarian) loggedUser;
            librarian.showMenu();
            scanner.nextInt();

        } else {

            System.out.println("Incorrect data. Please, try again!");
            login();

        }

    }

    public User login(){
        System.out.println("Enter your username:");
        String username = scanner.next();
        System.out.println("Enter your password:");
        int pass = scanner.nextInt();

        if (username.equals(librarian.getUsername()) && pass == librarian.getPass()){
            return librarian;
        } else {
            for (Reader reader : readers) {
                if (reader.getUsername().equals(username) && pass == reader.getPass()){
                    System.out.printf("Hello, %s", reader.getName());
                    return reader;
                }
            }
        }
        return null;
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

    public void addBook(String name, String author, int year){
        books.add(new Book(name, author, year));
    }

    public void showAvailableBooks(){

    }

    public void addReader(){}
}
