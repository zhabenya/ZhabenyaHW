package zhabenya_homework2.library;

import java.util.Scanner;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Librarian extends User {

    protected Library library;
    private LibrarianMenu menu = new LibrarianMenu(library);

    Scanner scanner = new Scanner(System.in);

    public Librarian(String name, String username, Library library) {
        super(name, username);
        this.library = library;
    }

    public int showMenu(){
        System.out.printf("Hello, %s\n", getName());
        int choice = menu.load();
        switch (choice){
            case 1:
                library.seeAllBooks();
                break;
            case 2:
                System.out.println("Enter author's name");
                String author = scanner.next();

                library.showBooksByAuthor();



            default:
                System.out.println("Incorrect value. Try again!");
                showMenu();
        }
    }


}

