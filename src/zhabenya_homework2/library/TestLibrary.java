package zhabenya_homework2.library;

/**
 * Created by zhabenya on 24.11.15.
 */
public class TestLibrary extends Library {

    public static void main(String[] args) {

        Library myLibrary = new Library();


        myLibrary.createLibrarian("Hermione Granger", "witch");
        myLibrary.librarian.setPass(9871);

        myLibrary.createReader("Harry Potter", "potter", 934);
        myLibrary.createReader("1", "1", 111);

        myLibrary.addBook("Harry Potter", "J.K.Rowling", 1998);
        myLibrary.addBook("Harry Potter 2", "J.K.Rowling", 2000);

        myLibrary.enter();

        myLibrary.seeAllBooks();

    }


}
