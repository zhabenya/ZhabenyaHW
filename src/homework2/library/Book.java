package homework2.library;

public class Book {

    private int bookId;
    private String name;
    private String author;
    private int year;
    private boolean available;
    protected String takenBy = "";


    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        setBookId();
        setAvailable(true);
    }

    public void setBookId() {
        int bookIdRange = 10000;
        this.bookId = (int) (Math.random() * bookIdRange);
    }

    public int getBookId() {
        return bookId;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getTakenBy() {
        return takenBy;
    }

    public void setTakenBy(String takenBy) {
        this.takenBy = takenBy;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return  "#" + bookId + " \\ " + name + " \\ " + author + " \\ " + year;
    }



}
