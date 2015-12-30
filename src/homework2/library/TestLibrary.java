package homework2.library;

/**
 * Created by zhabenya on 24.11.15.
 */
public class TestLibrary extends Library {

    public static void main(String[] args) {

        Library myLibrary = new Library();

        myLibrary.createLibrarian("Hermione Granger", "witch", myLibrary);
        myLibrary.librarian.setPass(9871);

        myLibrary.createReader("Harry Potter", "potter", 934);
        myLibrary.createReader("Ron Wisley", "red", 1111);
        myLibrary.createReader("1", "1", 111);

        myLibrary.addBook("Harry Potter and the Philosopher's Stone", "J.K.Rowling", 1997);
        myLibrary.addBook("Harry Potter and the Chamber of Secrets", "J.K.Rowling", 1998);
        myLibrary.addBook("Harry Potter and the Prisoner of Azkaban", "J.K.Rowling", 1999);
        myLibrary.addBook("Harry Potter and the Goblet of Fire", "J.K.Rowling", 2000);
        myLibrary.addBook("Harry Potter and the Order of teh Phoenix", "J.K.Rowling", 2001);

        myLibrary.enter();

    }


}
