package zhabenya_homework4.pizzeria;

/**
 * Created by zhabenya on 04.12.15.
 */
public class Pizza {

    private int id;

    public Pizza() {
        setId();
    }

    public Pizza(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        int idRange = 10000;
        id = (int) (Math.random() * idRange);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Pizza && ((Pizza) obj).getId() == id);
    }

    @Override
    public String toString() {
        return "Pizza " + id;
    }
}
