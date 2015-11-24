package zhabenya_homework1;

public class MyString {

    String absString = "";

    public void showString(String toShow){
        System.out.println(toShow);
    }

    public String addArrayToString(char[] charArray){
        for (char i : charArray
             ) {
            absString += i;
        }
        showString(absString);
        return absString;
    }

    public String concatString(String toConcat){
        absString += toConcat;
        showString(absString);
        return absString;
    }

    public String makeAllBigLetters(){
        String bigString = absString.toUpperCase();
        showString(bigString);
        return bigString;
    }

    public String maleAllSmallLetters(){
        String smallString = absString.toLowerCase();
        showString(smallString);
        return smallString;
    }

    public void findInString(String what, String where){
        boolean found = false;
        for (int i = 0; i <= where.length()-what.length(); i++) {
            if (where.substring(i, i+what.length()).equals(what)) {
                found = true;
                System.out.println(what + " successfully found in " + where + " starting at " + i + " position");
            }
        }
        if (!found) System.out.println("Sorry, couldn't find " + what + " in " + where);
    }

    public void findAndShowInString(String what, String where){
        String res = "";
        for (int i = 0; i < where.length(); i++) {
            if (i < (where.length()-what.length()) && where.substring(i, i+what.length()).equals(what)) {
                res += what.toUpperCase();
                i += what.length()-1;
            } else {
                res += where.charAt(i);
            }
        }
        showString(res);
    }

    public void removeStringSpaces(String strToModify){
        String res = "";
        for (int i = 0; i < strToModify.length(); i++) {
            if (strToModify.charAt(i) != ' ') {
                res += strToModify.charAt(i);
            }
        }
        showString(res);
    }

    public void compareWithString(String otherString){
        if (absString.equalsIgnoreCase(otherString)) {
            System.out.println("Strings " + absString + " and " + otherString + " are equal");
        } else if (absString.length() == otherString.length()) {
            System.out.println("Strings " + absString + " and " + otherString + " have equal length");
        } else {
            System.out.println("Strings " + absString + " and " + otherString + " are not equal");
        }
    }
}
