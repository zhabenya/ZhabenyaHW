package zhabenya_homework4.pizzeria;

/**
 * Created by zhabenya on 04.12.15.
 */
public class TestPizzeria {

    public static void main(String[] args) {

        runPizzeria(new Pizzeria(10));

        Pizzeria myMamaMia = new Pizzeria();
        runPizzeria(myMamaMia);
        runSpecial(myMamaMia);
    }

    public static void runPizzeria(Pizzeria pizzeria){

        DeliveryGuy johny = new DeliveryGuy("Johny", pizzeria);
        pizzeria.addDeliveryGuy(johny);

        DeliveryGuy max = new DeliveryGuy("Max", pizzeria);
        pizzeria.addDeliveryGuy(max);

        PizzaMaker mrMadman = new PizzaMaker("Mr. Madman", pizzeria);
        pizzeria.addPizzaMaker(mrMadman);

        mrMadman.takeOrder();
        mrMadman.takeOrder();

        mrMadman.bake();

        johny.deliverPizza();

        mrMadman.bake();

        max.deliverPizza();

        System.out.println();
    }

    public static void runSpecial(Pizzeria pizzeria){

        Pizza pizza = new Pizza(1111);
        PizzaMaker maker = pizzeria.pizzaMakers.get(0);

        maker.takeOrder(pizza.getId());

        pizzeria.checkPizzaStatus(pizza);

        maker.bake();
        pizzeria.checkPizzaStatus(pizza);

        maker.makeSpecialOrder();

        maker.takeOrder();
        maker.takeOrder();

        pizzeria.showQs();

        pizzeria.switchElementsInQ(pizzeria.pizzaOrdersQ);

        pizzeria.showQs();
    }


}
