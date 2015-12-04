package zhabenya_homework4.pizzeria;

/**
 * Created by zhabenya on 03.12.15.
 */
public class PizzaMaker {

    private Pizzeria pizzeria;
    public String name;

    public PizzaMaker( String name, Pizzeria pizzeria) {
        this.pizzeria = pizzeria;
        this.name = name;
    }

    public void takeOrder(){
        Pizza pizza = new Pizza();
        pizzeria.pizzaOrdersQ.enqueue(pizza);
        System.out.println("Order " + pizza.getId() + " is created");
    }

    public void takeOrder(int pizzaId){
        Pizza pizza = new Pizza(pizzaId);
        pizzeria.pizzaOrdersQ.enqueue(pizza);
        System.out.println("Order " + pizza.getId() + " is created");
    }

    public void makeSpecialOrder(){
        if (pizzeria.hasSpecialMenu()) {
            Pizza pizza = new Pizza();
            ((LinkedQ) pizzeria.pizzaOrdersQ).addToHead(pizza);
            bake();
        } else {
            System.out.println("Sorry, get back to the queue");
        }
    }

    public void bake(){
        Pizza pizza = (Pizza) pizzeria.pizzaOrdersQ.dequeue();
        System.out.println("Pizza " + pizza.getId() + " is baking");
        pizzeria.pizzaDeliveryQ.enqueue(pizza);
        System.out.println("Pizza #" + pizza.getId() + " is ready. " + name);
    }



}
