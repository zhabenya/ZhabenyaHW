package homework1;

public class MyNumber {

    int value;

    public int addNumbers(int value2){
        return (value + value2);
    }

    public int subtractNumbers(int value2){
         return value - value2;
    }

    public int multiplyNumbers(int value2){
        return value * value2;
    }

    public int divideNumbers(int value2){
        if (value2 == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return ( value / value2);

    }

    public int powerNumbers(int value2){
        return (int) Math.pow(value, value2);
    }

    public int factorialNumber(){
        return factorial(value);
    }

    private int factorial(int value) {
        if (value <= 1) return value;
        return value * factorial(value - 1);
    }

    public int moduloNumbers(int value2){
        if (value2 == 0) {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        return value % value2;
    }

    public int findLargerNumber(int value2){
        return Math.max(value, value2);
    }

    public int findSmallerNumber(int value2){
        return Math.min(value, value2);
    }

}
