package zhabenya_homework2.library;

import java.util.Scanner;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Librarian extends User {

    Scanner scanner = new Scanner(System.in);

    protected Librarian(String name, String username) {
        super(name, username);
    }

    public void showMenu(){
        System.out.printf("Hello, %s\n", getName());
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

