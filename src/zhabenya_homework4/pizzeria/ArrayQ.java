package zhabenya_homework4.pizzeria;

public class ArrayQ extends Queue {

    private static final int DEFAULT_ARRAY_SIZE = 10;

    private Object[] array;
    private int size;

    public ArrayQ() {
        array = new Object[DEFAULT_ARRAY_SIZE];
    }

    public ArrayQ(int size) {
        array = new Object[size];
    }

    @Override
    public void enqueue(Object object) {

        if(tail == array.length){
            System.err.println("Queue is full");
            return;
        }

        array[tail] = object;
        tail++;
        size++;
    }

    @Override
    public Object dequeue() {
        if(size == 0){
            return null;
        }

        Object headObj = array[head];
        head++;
        size--;
        return headObj;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String res = "Queue \n";
        for (Object o: array) {
            res += o.toString() + " ";
        }
        return res;
    }

}
