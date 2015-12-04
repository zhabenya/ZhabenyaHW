package zhabenya_homework4.pizzeria;

/**
 * Created by zhabenya on 03.12.15.
 */
public class DeliveryGuy {

    private Pizzeria pizzeria;
    public String name;

    public DeliveryGuy(String name, Pizzeria pizzeria) {
        this.name = name;
        this.pizzeria = pizzeria;
    }

    public void deliverPizza(){
        Pizza pizza = (Pizza) pizzeria.pizzaDeliveryQ.dequeue();
        if (pizza == null) System.out.println("Sorry, your pizza is not ready.");
        else System.out.println("Pizza # " + pizza.getId() + " is delivered by " + name);
    }

}
