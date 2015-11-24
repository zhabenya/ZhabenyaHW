package zhabenya_homework2.library;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Reader extends User {

    private int userId = 1;
    public int maxBooksCount = 3; //public so Librarian can change it

    public Reader(String name, String lastName, int pass) {
        super(name, lastName);
        setUserId(userId);
        setPass(pass);
    }

    private int setUserId(int userId) {
        this.userId = userId;
        userId++;
        return userId;
    }

    public int takeBook(String name){

    }

    public void showBooks(){

    }

}
