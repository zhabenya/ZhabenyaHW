package zhabenya_homework2.library;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Reader extends User {

    public int maxBooksCount = 3; //public so Librarian can change it

    protected Reader(String name, String username) {
        super(name, username);
    }

    public void takeBook(String name){

    }

    public void showBooks(){

    }

}
