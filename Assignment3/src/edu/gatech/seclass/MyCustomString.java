/**
 * Created by Corey Crooks on 1/21/18.
 * ccrooks6@gatech.edu
 */
public class MyCustomString implements MyCustomStringInterface {

    private String mycustomstring;

    @Override
    public String getString() {
        return mycustomstring;
    }

    @Override
    public void setString(String string) {
        this.mycustomstring = string;
    }


    /*
    Simple method to count numbers within a string.
     */
    @Override
    public int countNumbers() {

        int counter = 0;
        boolean prev = false;


        for (int i = 0; i < mycustomstring.length(); i++) {
            if (Character.isDigit(mycustomstring.charAt(i))) {
                if (!prev) {
                    counter++;
                    prev = true;
                }
            } else {
                prev = false;
            }
        }
        return counter;
    }



    // Method to increase digits from 0 -9, min 0 and max 9 if wrap is false
    // if wrap is true then circle back to 0 and add
    // if negative < 0 then wrap back from 9.

    @Override
    public String increaseDigits(int n, boolean wrap) {

        if (n > 9 || n < -9 && mycustomstring != null) {
            throw new IllegalArgumentException();
        }

        if (mycustomstring == null) {
            throw new NullPointerException();
        }
        String alteredString = "";



        for (int i = 0; i < mycustomstring.length(); i++) {
            if (Character.isDigit(mycustomstring.charAt(i))) {
                int val = 0;
                if (!wrap) {
                    val = Character.getNumericValue(mycustomstring.charAt(i)) + n;
                    if (val > 9)
                        val = 9; // since no wrap will always be 9.
                    if (val < 0)
                        val = 0;
                } else {
                    // handle wrap
                    val = Character.getNumericValue(mycustomstring.charAt(i)); // grab current character
                    // 3 and its -4
                    int newVal = val + n;
                    if (newVal < 0) {
                        val = 10 + newVal;
                    } else if (newVal > 9) {
                        // newval - 9
                        val = 0;
                        val = newVal - 10;
                    } else {
                        val = newVal;
                    }

                }
                alteredString += String.valueOf(val);
            } else {

                alteredString += mycustomstring.charAt(i) + "";
            }
        }
        return alteredString;
    }

    @Override
    public void convertLettersToDigitsInSubstring(int startPosition, int endPosition) {
        /*
        Test if the string is null then throw error
         */
        if (mycustomstring == null) {
            throw new NullPointerException();
        }

        if (startPosition < 1 || endPosition > this.mycustomstring.length()) {
            throw new MyIndexOutOfBoundsException();
        }

        // Get substring and replace with regex (?i) case insensitivity

        String myString = mycustomstring.substring(startPosition - 1, endPosition);

        myString = myString.replaceAll("(?i)a", "01");
        myString = myString.replaceAll("(?i)b", "02");
        myString = myString.replaceAll("(?i)c", "03");
        myString = myString.replaceAll("(?i)d", "04");
        myString = myString.replaceAll("(?i)e", "05");
        myString = myString.replaceAll("(?i)f", "06");
        myString = myString.replaceAll("(?i)g", "07");
        myString = myString.replaceAll("(?i)h", "08");
        myString = myString.replaceAll("(?i)i", "09");
        myString = myString.replaceAll("(?i)j", "10");
        myString = myString.replaceAll("(?i)k", "11");
        myString = myString.replaceAll("(?i)l", "12");
        myString = myString.replaceAll("(?i)m", "13");
        myString = myString.replaceAll("(?i)n", "14");
        myString = myString.replaceAll("(?i)o", "15");
        myString = myString.replaceAll("(?i)p", "16");
        myString = myString.replaceAll("(?i)q", "17");
        myString = myString.replaceAll("(?i)r", "18");
        myString = myString.replaceAll("(?i)s", "19");
        myString = myString.replaceAll("(?i)t", "20");
        myString = myString.replaceAll("(?i)u", "21");
        myString = myString.replaceAll("(?i)v", "22");
        myString = myString.replaceAll("(?i)w", "23");
        myString = myString.replaceAll("(?i)x", "24");
        myString = myString.replaceAll("(?i)y", "25");
        myString = myString.replaceAll("(?i)z", "26");



        mycustomstring = mycustomstring.substring(0, startPosition - 1) + myString + mycustomstring.substring(endPosition, mycustomstring.length());

    }
}