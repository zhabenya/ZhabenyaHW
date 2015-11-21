package HomeWork1;

import java.util.Scanner;

public class TestArray {

    public static void main(String[] args) {

        MyArray myNewArray = new MyArray();

        //setting array length
        System.out.println("How many values do you want in your array?");
        Scanner scan = new Scanner(System.in);
        int arraySize = scan.nextInt();
        myNewArray.setSize(arraySize);

        //filling array
        for (int i = 0; i < arraySize; i++) {
            System.out.println("Enter " + (i+1) + " element of your array:");
            int arrayElement = scan.nextInt();
            myNewArray.initArrayElement(i, arrayElement);
        }
        myNewArray.showMyArray();

        System.out.println("The minimal element is " + myNewArray.findArrayMin());

        System.out.println("The maximal element is " + myNewArray.findArrayMax());

        myNewArray.fillArrayRandomly();

        System.out.println("How many elements do you want to add to your array?");
        int addElements = scan.nextInt();
        myNewArray.enlargeArray(addElements);
        for (int i = 0; i < addElements; i++) {
            System.out.println("Enter " + (i + 1) + " additional element:");
            myNewArray.fillAddElements(scan.nextInt(), arraySize + i);
        }
        myNewArray.showMyArray();

        myNewArray.sortArrayIncreasing();

        myNewArray.sortArrayDecreasing();

        int[] arrayToCompare = {2,3,7,10,11};

        myNewArray.compareArrays(arrayToCompare);
    }


}
