package zhabenya_homework4.pizzeria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zhabenya on 04.12.15.
 */
public class LinkedQ extends Queue {

    List<Object> listQ;

    public LinkedQ() {
        listQ = new ArrayList<>();
    }

    @Override
    public int size() {
        return listQ.size();
    }

    @Override
    public void enqueue(Object object) {
        listQ.add(object);
        tail++;
    }

    @Override
    public Object dequeue() {
        if (listQ.isEmpty()) return null;

        Object headObj = listQ.get(head);
        listQ.remove(head);
        tail--;
        return headObj;
    }

    @Override
    public String toString() {
        String res = "Queue \n";
        for (Object o: listQ) {
            res += o.toString() + " ";
        }
        return res;
    }

    public void addToHead(Object object){
        listQ.add(head, object);
        tail++;
    }

    public boolean findInQ(Object object){
        for (Object o : listQ) {
            return o.equals(object);
        }
        return false;
    }

    public void switchElements(){
        Object temp = listQ.get(head);
        listQ.remove(head);
        listQ.set(head, listQ.get(tail - 2));
        listQ.add(temp);
    }

    public void reverseQ(){
        Collections.reverse(listQ);
    }

}
