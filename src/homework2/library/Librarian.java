package homework2.library;

/**
 * Created by zhabenya on 21.11.15.
 */
public class Librarian extends User {

    protected Library library;
    protected LibrarianMenu menu;

    public Librarian(String name, String username, Library library) {
        super(name, username);
        this.library = library;
        menu = new LibrarianMenu(library);
    }


}

