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

    protected void createLibrarian(String name, String username, Library library){
        librarian = new Librarian(name, username, library);
    }

    protected void createReader(String name, String username, int pass){
        Reader newReader = new Reader(name, username, this);
        readers.add(newReader);
        newReader.setPass(pass);
    }

    protected void enter(){
        User loggedUser = login();

        if (loggedUser instanceof Reader) {

            Reader reader = (Reader) loggedUser;
            System.out.printf("Hello, %s\n", reader.getName());
            reader.menu.showMenu();

        } else if (loggedUser instanceof Librarian){

            Librarian librarian = (Librarian) loggedUser;
            System.out.printf("Hello, %s\n", librarian.getName());
            librarian.menu.showMenu();

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
                    return reader;
                }
            }
        }
        return null;
    }

    public void addBook(String name, String author, int year){
        Book newBook = new Book(name, author, year);
        checkNewBookId(newBook);
        books.add(newBook);
    }

    private Book checkNewBookId(Book newBook){
        for (Book book : books) {
            if (book.getBookId() == newBook.getBookId()) newBook.setBookId();
        }
        return newBook;
    }

    public void showAllBooks(){
        System.out.println("All books in your library");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showAvailableBooks(){
        for (Book book : books) {
            if (book.isAvailable()){
                System.out.println(book);
            }
        }
    }

    public void showBooksByAuthor(String author){
        boolean empty = true;
        for (Book book: books) {
            if (book.getAuthor().equals(author)){
                System.out.println(book);
                empty = false;
            }
        }
        if (empty) System.out.println("Sorry we don't have book of this author");

    }

    public void showNewBooks(int year){
        for (Book book: books) {
            if (book.getYear() >= year){
                System.out.println(book);
            }
        }
    }

    public void showBooksTakenBy(String user){
        boolean empty = true;
        for (Book book : books) {
            if (book.getTakenBy().equals(user)){
                System.out.println(book);
                empty = false;
            }
        }
        if (empty) System.out.println("None books were taken");
    }

    public Book findBook(){
        System.out.println("Enter book ID");
        int bookId = scanner.nextInt();
        for (Book book: books) {
            if (book.getBookId() == bookId)
                return book;
        }
        System.out.println("Wrong book ID");
        return null;
    }
}
