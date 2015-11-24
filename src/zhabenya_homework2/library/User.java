package zhabenya_homework2.library;

/**
 * Created by zhabenya on 21.11.15.
 */
public class User {

    private String name;
    private String lastName;
    private int pass;

    public User(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
        setPass(pass);
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

}

