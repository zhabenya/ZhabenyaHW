package zhabenya_homework2.library;

import java.util.Scanner;

/**
 * Created by zhabenya on 26.11.15.
 */
public class LibrarianMenu {

    Scanner scanner = new Scanner(System.in);

    private Library library;


    public LibrarianMenu(Library library) {
        this.library = library;
    }

    public int load(){
        System.out.println("Choose your action\n" +
                "1. See all books\n" +
                "2. See all book by author\n" +
                "3. See all books taken from library\n" +
                "4. See all books taken by reader\n" +
                "5. See all books published after\n" +
                "6. Add new book\n" +
                "7. See all reader\n" +
                "8. See all readers in blacklist\n" +
                "9. Add new reader\n" +
                "10. Give reader the book\n");
        return scanner.nextInt();
    }



    public void showTakenBooks(){
        System.out.println("All taken books");
        for (Book book : library.books) {
            if (!book.isAvailable()){
                System.out.println(book + " by " + book.getTakenBy());
            }
        }
    }

    public void showBooksTakenBy(String user){
        System.out.println("All books taken by " + user);
        for (Book book : library.books) {
            if (book.getTakenBy().equals(user)){
                System.out.println(book);
            }
        }
    }

    public Book addBookManually(){
        System.out.println("Enter new book info");
        System.out.println("Book name");
        String name = scanner.next();
        System.out.println("Book author");
        String author = scanner.next();
        System.out.println("Year edition");
        int year = scanner.nextInt();
        return new Book(name, author, year);
    }




}
