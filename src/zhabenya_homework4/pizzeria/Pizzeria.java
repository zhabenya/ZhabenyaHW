package zhabenya_homework4.pizzeria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhabenya on 03.12.15.
 */
public class Pizzeria {

    int qSize;
    public Queue pizzaOrdersQ;
    public Queue pizzaDeliveryQ;
    private boolean specialMenu;

    public List<PizzaMaker> pizzaMakers = new ArrayList<>();
    public List<DeliveryGuy> deliveryGuys = new ArrayList<>();

    public boolean hasSpecialMenu() {
        return specialMenu;
    }

    public Pizzeria(int qSize) {
        this.qSize = qSize;
        pizzaOrdersQ = new ArrayQ(qSize);
        pizzaDeliveryQ = new ArrayQ(qSize);
        specialMenu = false;
    }

    public Pizzeria(){
        pizzaOrdersQ = new LinkedQ();
        pizzaDeliveryQ = new LinkedQ();
        specialMenu = true;
    }

    public void addPizzaMaker(PizzaMaker pizzaMaker){
        pizzaMakers.add(pizzaMaker);
    }

    public void addDeliveryGuy(DeliveryGuy deliveryGuy){
        deliveryGuys.add(deliveryGuy);
    }

    public void checkPizzaStatus(Pizza pizza){
        if (hasSpecialMenu()) {
            if (((LinkedQ) pizzaOrdersQ).findInQ(pizza))
                System.out.println("Your order is processing.");
            else if (((LinkedQ) pizzaDeliveryQ).findInQ(pizza))
                System.out.println("Your pizza is ready, wait for delivery.");
            else
                System.out.println("Order not found.");
        }
    }

    public void showQs(){
        if (hasSpecialMenu()){
            System.out.println("Order" + pizzaOrdersQ);
            System.out.println("Delivery" + pizzaDeliveryQ);
        }
    }

    public Queue switchElementsInQ(Queue queue){
        if (queue instanceof LinkedQ){
            ((LinkedQ) queue).switchElements();
            return queue;
        }
        return null;
    }

}
