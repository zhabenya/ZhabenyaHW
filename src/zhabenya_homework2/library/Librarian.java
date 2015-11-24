package zhabenya_homework2.library;

import java.util.Scanner;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Librarian extends User {

    Scanner scanner = new Scanner(System.in);

    protected Librarian(String name, String username) {
        super(name, username);
    }

    public static void login() {
        System.out.println("Enter your username:");

    }

    public void openLibMenu(){
        System.out.println("Enter your name:");

    }

    public void showLibOptions(){
        System.out.println();
    }

}
