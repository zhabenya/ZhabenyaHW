package zhabenya_homework2.library;

import java.util.Scanner;

/**
 * Created by zhabenya on 21.11.15.
 */
public class User {

    private String name;
    private String username;
    private int pass;

    public User(String name, String username) {
        this.name = name;
        this.username = username;
        setPass(pass);
    }

    protected void setPass(int pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public int getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

