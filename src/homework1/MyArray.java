package homework1;

public class MyArray {

    private int arraySize;

    private int[] absArray;

    public MyArray(int[] absArray) {
        this.absArray = absArray;
        arraySize = absArray.length;
    }

    public int getArraySize() {
        return arraySize;
    }

    public int[] getAbsArray() {
        return absArray;
    }

    public String showArray(int[] array){
        String res = "{ ";
        for (int i : array) {
            res += i + " ";
        }
        res += "}";
        return res;
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

    public int[] fillArrayRandomly(){
        int[] absArray2 = new int[arraySize];
        for (int i = 0; i < absArray2.length; i++) {
            absArray2[i] = (int)(Math.random()*50);
        }
        return absArray2;
    }

    public int[] addElementToArray(int addElement){
        int[] newArray = new int[getArraySize() + 1];

        for (int i = 0; i < absArray.length; i++) {
            newArray[i] = absArray[i];
        }
        newArray[newArray.length - 1] = addElement;

        return newArray;
    }

    public int[] sortArrayIncreasing(){
        int[] sortedArray = absArray;

        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                if (sortedArray[i] > sortedArray[j]) {
                    int temp = sortedArray[i];
                    sortedArray[i] = sortedArray[j];
                    sortedArray[j] = temp;
                }
            }
        }
        return sortedArray;
    }

    public int[] sortArrayDecreasing(){
        int[] sortedArray = absArray;

        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = i + 1; j < sortedArray.length; j++) {
                sortedArray[i] = Math.max(sortedArray[i], sortedArray[j]);
            }
        }

        return sortedArray;
    }

    public boolean compareArraysLengthEqual(int[] otherArray){
        return  absArray.length == otherArray.length;
    }

    public boolean compareArraysEqual(int[] otherArray){
        if (compareArraysLengthEqual(otherArray)) {

            for (int i = 0; i < absArray.length; i++) {
                if (absArray[i] != otherArray[i]) return false;
            }
            return true;

        } else {
            return false;
        }
    }
}
