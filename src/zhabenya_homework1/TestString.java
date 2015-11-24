package zhabenya_homework1;

public class TestString {

    public static void main(String[] args) {

        MyString myString = new MyString();

        char[] addToString = {'k', 'e', 'e', 'p'};
        System.out.println("Your string");
        myString.addArrayToString(addToString);

        String strToConcat = "Calm";
        System.out.println("Your new string");
        myString.concatString(strToConcat);

        System.out.println("Your string to Upper Case");
        myString.makeAllBigLetters();

        System.out.println("Your string to Lower Case");
        myString.maleAllSmallLetters();

        myString.findInString("cat", "cat&dog&cat");

        myString.findInString("cat", "encapsulation");

        myString.findAndShowInString("cat", "concatenation");

        myString.removeStringSpaces("I won't let this build up inside of me");

        myString.compareWithString("keepcalm");

        myString.compareWithString("and wait");

        myString.compareWithString("better go and study");
    }
}
