package zhabenya_homework2.library;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Reader extends User {

    protected boolean isBlacklisted;
    protected int booksTaken;

    public int maxBooksPermitted = 3; //public so Librarian can change it

    protected Reader(String name, String username) {
        super(name, username);
        setBlacklisted(false);
    }

    public boolean isBlacklisted() {
        return isBlacklisted;
    }

    public void setBlacklisted(boolean blacklisted) {
        isBlacklisted = blacklisted;
    }

    public void takeBook(String name){

    }

    public void giveBookBack(){

    }

    protected boolean canTakeMoreBooks(){
        return booksTaken < maxBooksPermitted;
    }
}
