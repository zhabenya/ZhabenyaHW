package zhabenya_homework1;

public class TestNumbers {

    public static void main(String[] args) {

        dealWithNumbers(3, 0);

        dealWithNumbers(5, 2);

    }

    public static void dealWithNumbers(int num1, int num2){

        Numbers num = new Numbers();

        num.value1 = num1;
        num.value2 = num2;

        num.showAllMathResults();

        System.out.println();
    }
}
