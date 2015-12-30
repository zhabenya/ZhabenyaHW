package homework2.library;

import java.util.Scanner;

/**
 * Created by zhabenya on 26.11.15.
 */
public class LibrarianMenu {

    private Library library;
    protected LibrarianMenu(Library library) {
        this.library = library;
    }
    Scanner scanner = new Scanner(System.in);

    private void load(){
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
                "10. Add reader to blacklist\n" +
                "11. Give reader the book\n");
    }

    protected void showMenu(){
        load();
        switch (scanner.nextInt()){
            case 1:
                library.showAllBooks();
                showExitMenu();
                break;
            case 2:
                System.out.println("Enter author's name");
                library.showBooksByAuthor(scanner.next());
                showExitMenu();
                break;
            case 3:
                showTakenBooks();
                showExitMenu();
                break;
            case 4:
                System.out.println("Enter reader's username");
                library.showBooksTakenBy(scanner.next());
                showExitMenu();
                break;
            case 5:
                System.out.println("Enter year");
                library.showNewBooks(scanner.nextInt());
                showExitMenu();
                break;
            case 6:
                Book newBook = addBookManually();
                library.addBook(newBook.getName(), newBook.getAuthor(), newBook.getYear());
                showExitMenu();
                break;
            case 7:
                showAllReaders();
                showExitMenu();
                break;
            case 8:
                showAllBlacklisted();
                showExitMenu();
                break;
            case 9:
                addReader();
                showExitMenu();
                break;
            case 10:
                addReaderToBlacklist();
                showExitMenu();
                break;
            case 11:
                giveBookToReader();
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


    private void showTakenBooks(){
        System.out.println("All taken books");
        for (Book book : library.books) {
            if (!book.isAvailable()){
                System.out.println(book + " taken by " + book.getTakenBy());
            }
        }
    }


    private Book addBookManually(){
        System.out.println("Enter new book info");
        System.out.println("Book name");
        String name = scanner.next();
        System.out.println("Book author");
        String author = scanner.next();
        System.out.println("Year edition");
        int year = scanner.nextInt();
        System.out.printf("The book  %s, \"%s\" successfully added to the library\n", author, name);
        return new Book(name, author, year);
    }

    private void showAllReaders(){
        for (Reader reader : library.readers) {
            if (reader.isBlacklisted) {
                System.out.println(reader + " * ");
                break;
            }
            System.out.println(reader);
        }
        System.out.println("Users marked with * are blacklisted.");
    }

    private void showAllBlacklisted(){
        System.out.println("Blacklisted readers");
        for (Reader reader : library.readers) {
            if (reader.isBlacklisted) {
                System.out.println(reader);
            }
        }
        System.out.println("Remove someone from blacklist?\n" +
                "1. Yes\n" +
                "2. No");
        if (scanner.nextInt() == 1) {
            findReader().setBlacklisted(false);
        }
    }

    private void addReader(){
        System.out.println("Enter new reader's name");
        String name = scanner.next();
        System.out.println("and his username");
        String username = scanner.next();
        library.readers.add(new Reader(name, username, library));
    }

    private void addReaderToBlacklist(){
        showAllReaders();
        System.out.println("Whom do you want to blacklist?");
        Reader readerToBlack = findReader();
        readerToBlack.setBlacklisted(true);
        System.out.println("Reader " + readerToBlack.getName() + " is blacklisted.");
    }

    public void giveBookToReader(){

        showAllReaders();
        Reader reader = findReader();

        if (reader.canTakeBooks()) {
            library.showAvailableBooks();
            Book book = library.findBook();
            book.setAvailable(false);
            book.setTakenBy(reader.getUsername());
            reader.booksTaken++;
            System.out.println("The book \"" + book.getName() + "\" is taken by " + reader.getName());
        }
    }

    private Reader findReader(){
        System.out.println("Enter reader's username");
        String user = scanner.next();
        for (Reader reader : library.readers) {
            if (reader.getUsername().equals(user)){
                return reader;
            }
        }
        System.out.println("Reader not found.");
        showMenu();
        return null;
    }




}
