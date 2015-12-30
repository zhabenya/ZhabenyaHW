package homework2.library;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Reader extends User {

    protected boolean isBlacklisted;
    protected int booksTaken;
    protected ReaderMenu menu;

    public int maxBooksPermitted = 3; //public so Librarian can change it

    protected Reader(String name, String username, Library library) {
        super(name, username);
        setBlacklisted(false);
        menu = new ReaderMenu(library, this);
    }

    protected boolean isBlacklisted() {
        return isBlacklisted;
    }

    protected void setBlacklisted(boolean blacklisted) {
        isBlacklisted = blacklisted;
    }

    protected boolean canTakeBooks(){
        if (isBlacklisted) {
            System.out.println("Sorry! Not allowed to take books.");
            return false;
        } else if (booksTaken >= maxBooksPermitted) {
            System.out.println("Taken books limit reached. Please, return books to the library!");
            return false;
        } else {
            return true;
        }
    }

}
