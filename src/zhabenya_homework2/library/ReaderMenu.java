package zhabenya_homework2.library;

import java.util.Scanner;

/**
 * Created by zhabenya on 27.11.15.
 */
public class ReaderMenu {

    private Library library;
    private Reader reader;
    Scanner scanner = new Scanner(System.in);

    protected ReaderMenu(Library library, Reader reader) {
        this.library = library;
        this.reader = reader;
    }

    private void load(){
        System.out.println("Choose your action\n" +
                "1. See all available books\n" +
                "2. See all book by author\n" +
                "3. See all books published after\n" +
                "4. Take book\n" +
                "5. Return book\n");
    }

    protected void showMenu() {
        load();
        switch (scanner.nextInt()) {
            case 1:
                library.showAvailableBooks();
                showExitMenu();
                break;
            case 2:
                System.out.println("Enter author's name");
                library.showBooksByAuthor(scanner.next());
                showExitMenu();
                break;
            case 3:
                System.out.println("Enter year");
                library.showNewBooks(scanner.nextInt());
                showExitMenu();
                break;
            case 4:
                takeBook();
                showExitMenu();
                break;
            case 5:
                returnBook();
                showExitMenu();
                break;
            default:
                System.out.println("Incorrect value. Try again!");
                showMenu();
        }
    }

    private void showExitMenu(){
        System.out.println("_____________________________");
        System.out.println("How would you like to proceed?\n" +
                "1. Show main menu\n" +
                "2. Exit");
        if (scanner.nextInt() == 1){
            showMenu();
        } else {
            System.out.println("Bye-bye! We'll be glad to see you again :)");
        }
    }

    private void takeBook(){
        if (reader.canTakeBooks()) {
            library.showAvailableBooks();
            Book book = library.findBook();
            book.setAvailable(false);
            book.setTakenBy(reader.getUsername());
            reader.booksTaken++;
            System.out.printf("You have taken %s, \"%s\". Enjoy your reading!\n", book.getAuthor(), book.getName());
        }
    }

    private void returnBook(){
        library.showBooksTakenBy(reader.getUsername());
        System.out.println("What book do you want to return?");
        Book book = library.findBook();
        book.setAvailable(true);
        book.setTakenBy("");
        reader.booksTaken--;
    }

}
