package zhabenya_homework2.library;

public class Book {

    private int bookId = 1;
    private String name;
    private String author;
    private int year;
    private boolean available;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
        setId(bookId);
    }

    private int setId(int id) {
        this.bookId = id;
        id++;
        return id;
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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + bookId + '\'' +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }


}
