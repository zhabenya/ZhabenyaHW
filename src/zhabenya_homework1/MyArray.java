package zhabenya_homework1;

import java.util.Arrays;

public class MyArray {

    int arraySize;
    int[] absArray;

    public int[] setSize(int size){
        arraySize = size;
        absArray = new int[arraySize];
        return absArray;
    }

    public int initArrayElement(int i, int arrayElement){
        absArray[i] = arrayElement;
        return absArray[i];
    }

    public void showMyArray(){
        System.out.println("Your array");
        showArray(absArray);
    }

    public void showArray(int[] someArray){
        System.out.print("{ ");
        for (int i : someArray) {
            System.out.print(i + " ");
        }
        System.out.println("}");
        System.out.println();
    }

    public int findArrayMin(){
        int min = absArray[0];
        for (int i : absArray) {
            min = Math.min(i, min);
        }
        return min;
    }

    public int findArrayMax(){
        int max = absArray[0];
        for (int i : absArray) {
            max = Math.max(i, max);
        }
        return max;
    }

    public void fillArrayRandomly(){
        System.out.println("Your size array filled randomly with numbers up to 50");
        int[] absArray2 = new int[arraySize];
        for (int i = 0; i < absArray2.length; i++) {
            absArray2[i] = (int)(Math.random()*50);
            System.out.print(absArray2[i] + " ");
        }
        System.out.println();
    }

    public void enlargeArray(int addElements){
        int[] tempArray = absArray;
        absArray = new int[arraySize + addElements];
        for (int i = 0; i < tempArray.length; i++) {
            absArray[i] = tempArray[i];
        }
    }

    public void fillAddElements(int newElement, int newElementPosition){
        absArray[newElementPosition] = newElement;
    }

    public void sortArrayIncreasing(){
        int[] sortedArray = absArray;
        Arrays.sort(sortedArray);
        System.out.println("Here is your sorted array in increasing order");
        showArray(sortedArray);
    }

    public void sortArrayDecreasing(){
        int[] tempArray = absArray;
        Arrays.sort(tempArray);
        int[] sortedArray = new int[absArray.length];
        for (int i = 0; i < tempArray.length; i++) {
            sortedArray[i] = tempArray[tempArray.length - 1 - i];
        }
        System.out.println("Here is your sorted array in decreasing order");
        showArray(sortedArray);
    }

    public void compareArrays(int[] otherArray){
        if (Arrays.equals(absArray, otherArray)){
            System.out.println("Arrays are totally equal");
        } else if (absArray.length == otherArray.length){
            System.out.println("Arrays have equal length");
        } else {
            System.out.println("Arrays are totally different");
        }
    }
}
