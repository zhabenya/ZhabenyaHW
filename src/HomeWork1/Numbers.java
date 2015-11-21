package HomeWork1;

public class Numbers {

    int value1;
    int value2;

    public void addNumbers(){
        System.out.println("The sum of numbers is " + (value1 + value2));
    }

    public void subtractNumbers(){
        System.out.println("The difference is " + (value1 - value2));
    }

    public void multiplyNumbers(){
        System.out.println("The product is " + value1 * value2);
    }

    public void divideNumbers(){
        if (value2 ==0) System.out.println("Can't calculate the quotient - division by zero");
        else {
            System.out.println("The division result is "+ ((double)value1 / (double)value2));
        }
    }

    public void powerNumbers(){
        System.out.println("The power result is " + Math.pow(value1, value2));
    }

    public void factorialNumbers(){
        factorial(value1);
        factorial(value2);
    }

    void factorial(int value) {
        long res = 1;
        if (value == 0) res = 0;
        else {
            for (int i = 1; i <= value; i++) {
                res = res * i;
            }
        }
        System.out.println("The factorial result for number " + value + " is " + res);
    }

    public void moduloNumbers(){
        if (value2 == 0) System.out.println("Can't calculate module - division by zero");
        else System.out.println("The modulo result is " + value1 % value2);
    }

    public void compareNumbers(){
        if (value1 == value2) System.out.println("Both numbers are equal");
        else System.out.println("Number " + Math.max(value1, value2) + " is larger than " + Math.min(value1, value2));
    }

    public void showAllMathResults(){

        System.out.println("Here are the results for the numbers " + value1 + " & " + value2 + ":");

        addNumbers();

        subtractNumbers();

        multiplyNumbers();

        divideNumbers();

        powerNumbers();

        factorialNumbers();

        moduloNumbers();

        compareNumbers();
    }
}
