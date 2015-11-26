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
        librarian = new Librarian(name, username, this);
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

            Librarian librarian = (Librarian) loggedUser;
            librarian.showMenu();

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
                    System.out.printf("Hello, %s\n", reader.getName());
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
        Book newBook = new Book(name, author, year);
        checkNewBookId(newBook);
        books.add(newBook);
        System.out.println("New book \"" + name + "\" successfully added.");
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

    public void seeAllBooks(){
        System.out.println("All books in your library");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showTakenBooks(){
        System.out.println("All taken books");
        for (Book book : books) {
            if (!book.isAvailable()){
                System.out.println(book + " by " + book.getTakenBy());
            }
        }
    }

    public void showBooksTakenBy(String user){
        System.out.println("All books taken by " + user);
        for (Book book : books) {
            if (book.getTakenBy().equals(user)){
                System.out.println(book);
            }
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
        for (Book book: books) {
            if (book.getAuthor().equals(author)){
                System.out.println(book);
            }
        }
        System.out.println("Sorry we don't have book of this author");;

    }

    public void showNewBooks(int year){
        for (Book book: books) {
            if (book.getYear() >= year){
                System.out.println(book);
            }
        }
    }

    public void addReader(){
        System.out.println("Enter new reader's name");
        String name = scanner.next();
        System.out.println("and his username");
        String username = scanner.next();
        readers.add(new Reader(name, username));
    }

    public void showAllReaders(){
        for (Reader reader : readers) {
            if (reader.isBlacklisted) {
                System.out.println(reader + " * ");
            }
            System.out.println(reader);
            System.out.println("Users marked with * are blacklisted.");
        }
    }

    public void showAllBlacklisted(){
        for (Reader reader : readers) {
            if (reader.isBlacklisted) {
                System.out.println(reader + " - blacklisted");
            }
        }
    }

    public void giveBookToReader(){

        Reader reader = findReader();

        if (reader.canTakeMoreBooks()){
            Book book = findBook();
            book.setAvailable(false);
            book.setTakenBy(reader.getUsername());
            reader.booksTaken++;
            System.out.println("The book \"" + book.getName() + "\" is taken by " + reader.getName());
        } else {
            System.out.println("You have reached you book limit. Please, return books to the library!");
        }
    }

    private Reader findReader(){
        System.out.println("Enter reader's username");
        String user = scanner.next();
        for (Reader reader : readers) {
            if (reader.getUsername().equals(user)){
                return reader;
            }
        }
        System.out.println("Reader not found.");
        return null;
    }

    private Book findBook(){
        showAvailableBooks();
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
