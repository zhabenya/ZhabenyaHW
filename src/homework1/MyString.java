package homework1;

public class MyString implements Comparable<MyString>{

    private char[] charString = {};

    public MyString(char[] chars) {
        this.charString = chars;
    }

    @Override
    public String toString() {
        String res = "";
        for (char c : charString) {
            res += c;
        }
        return res;
    }

    public String toString(char[] chars) {
        String res = "";
        for (char c : chars) {
            res += c;
        }
        return res;
    }

    public char[] concatString(String newString){
        int length1 = charString.length;
        char[] res = new char[length1 + newString.length()];

        for (int i = 0; i < res.length; i++) {
            if (i < length1) {
                res[i] = charString[i];
            } else {
                res[i] = newString.charAt(i - length1);
            }
        }
        return res;
    }

    public char[] makeAllBigLetters(){
        char[] toBigLetters = charString;
        for (int i = 0; i < toBigLetters.length; i++) {
            if (Character.isLowerCase(toBigLetters[i])) toBigLetters[i] = Character.toUpperCase(toBigLetters[i]);
        }
        return toBigLetters;
    }

    public char[] makeAllSmallLetters(){
        char[] toSmallLetters = charString;
        for (int i = 0; i < toSmallLetters.length; i++) {
            if (Character.isUpperCase(toSmallLetters[i])) toSmallLetters[i] = Character.toLowerCase(toSmallLetters[i]);
        }
        return toSmallLetters;
    }

    public boolean contains(String what){
        for (int i = 0; i < charString.length - what.length() + 1; i++) {
            for (int j = 0; j < what.length(); j++) {
                if (charString[i + j] == what.charAt(j)){
                    if (j == what.length() - 1)
                        return true;
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public char[] findAndShowInString(String what){
        char[] res = charString;
        int indexLastFound = -1;

        if (contains(what)) {
            for (int i = 0; i < res.length - what.length() + 1; i++) {
                for (int j = 0; j < what.length(); j++) {
                    if (charString[i + j] == what.charAt(j)) {
                        if (j == what.length() - 1)
                            indexLastFound = i + j;
                    } else {
                        break;
                    }
                }
            }

            for (int i = indexLastFound - what.length() + 1; i <= indexLastFound; i++) {
                res[i] = Character.toUpperCase(res[i]);
            }
        }
        return res;
    }

    public char[] removeSpaces(){

        int spacesNumber = 0;
        for (char c : charString) {
            if (c == ' ') spacesNumber++;
        }

        //fill array with non-spaces
        char[] res = new char[charString.length - spacesNumber];
        int count = 0;
        for (char c : charString) {
            if (c != ' '){
                res[count] = c;
                count++;
            }
        }

        return res;
    }

    public boolean compareWithStringByLength(String otherString){
        return (charString.length == otherString.length());
    }

    @Override
    public int compareTo(MyString o) {
        return charString.length - o.charString.length;
    }

}
