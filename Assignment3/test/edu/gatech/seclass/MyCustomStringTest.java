import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyCustomStringTest {

    private MyCustomStringInterface mycustomstring;

    @Before
    public void setUp() {
        mycustomstring = new MyCustomString();
    }

    @After
    public void tearDown() {
        mycustomstring = null;
    }

    /*
    Test method to check basic string counts
     */
    @Test
    public void testCountNumbers1() {
        mycustomstring.setString("H3y, l3t'5 put s0me d161ts in this 5tr1n6!11!!");
        assertEquals(9, mycustomstring.countNumbers());
    }

    /*
    Test 2 to test with no numbers present.
     */
    @Test
    public void testCountNumbers2() {

        mycustomstring.setString("ThIS IS A TEST WITH NO NUMBERS");
        assertEquals(0, mycustomstring.countNumbers());
    }


    /*
    Test 3 to test empty string
     */
    @Test
    public void testCountNumbers3() {
        //Empty String Test
        mycustomstring.setString(" ");
        assertEquals(0, mycustomstring.countNumbers());
    }


    /*
    Test 4 to check to verify method does not pick up negatives.
     */
    @Test
    public void testCountNumbers4() {
        mycustomstring.setString("Negative Numb-6er T-4est -1");
        assertEquals(3, mycustomstring.countNumbers());
    }

    /*
    Test for duplicates and to verify with contiguous sequence of digits.
     */
    @Test
    public void testCountNumbers5(){
        mycustomstring.setString("11111111111111111 Duplicate");
        assertEquals(1, mycustomstring.countNumbers());

    }

    /*
    Test to Verify difference between 1 2 and 12, along with 1 1 and 11. Verification to not go over 0-9
     */
    @Test
    public void testCountNumbers6() {
        mycustomstring.setString("12,11,MyTest 7,2, numbers, 1,Goodbye");
        assertEquals(5, mycustomstring.countNumbers());
    }



    /*
         Increase Digit Test 1: Test with multiple digits and wrapping disabled
        */
    @Test
    public void testIncreaseDigits1() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");

        assertEquals("H7y, l7t'9 put 94me d595ts in this 9tr5n9!55!!", mycustomstring.increaseDigits(4, false));
    }
    /*
         Increase Digit Test 2: Test with multiple digits and wrapping enabled
        */
    @Test
    public void testIncreaseDigits2() {
        mycustomstring.setString("H3y, l3t'5 put 50me d161ts in this 5tr1n6!11!!");
        assertEquals("H9y, l9t'1 put 16me d727ts in this 1tr7n2!77!!", mycustomstring.increaseDigits(-4, true));
    }
     /*
       Increase Digit Test 3: Test NullPointerException is thrown when there mycustomstring is not set
      */

    @Test(expected = NullPointerException.class)
    public void testIncreaseDigits3() {
        MyCustomString string = new MyCustomString();
        mycustomstring.increaseDigits(8, true);
    }
    /*
       Increase Digit Test 4: Test IllegalArgumentException is thrown.
        */

    @Test(expected = IllegalArgumentException.class)
    public void testIncreaseDigits4() {
        mycustomstring.setString("9");
        mycustomstring.increaseDigits(12, true);

    }
      /*
       Increase Digit Test 5: Test digit with digits at max or close to max with wrapping enabled.
        */

    @Test
    public void testIncreaseDigits5() {
        mycustomstring.setString("HEY9 !T-1e28sT");
        assertEquals("HEY7 !T-9e06sT", mycustomstring.increaseDigits(8, true));
    }
    /*
       Increase Digit Test 6: Test digit max with multiple digits at max or close to max
        */
    @Test
    public void testIncreaseDigits6() {
        mycustomstring.setString("HEY9 !T-1e28sT");
        assertEquals("HEY9 !T-9e99sT", mycustomstring.increaseDigits(8, false));
    }

    /*
    Increase Digit Test 7: Test negative reversal.
     */
    @Test
    public void testIncreaseDigits7() {
        mycustomstring.setString("00009999");

        assertEquals("11110000", mycustomstring.increaseDigits(-9, true));

    }

    /*
    Increase Digit Test 8: Returns exact string when no numbers are present.
     */
    @Test
    public void testIncreaseDigits8() {

        mycustomstring.setString("This is a test with no numbers");

        assertEquals("This is a test with no numbers", mycustomstring.increaseDigits(-5, true));
    }


    /*
    Increase Digit Test 9: Zero non wrap test, verify no wrap.
     */
    @Test
    public void testIncreaseDigits9() {


        mycustomstring.setString("hello 90, bye 2");

        assertEquals("hello 60, bye 0", mycustomstring.increaseDigits(-3, false));

    }

    /*
    Increase Digit Test 10: Test each increases by 2 no wrap
     */
    @Test
    public void testIncreaseDigits10() {
        mycustomstring.setString("hello 90, bye 2");

        assertEquals("hello 92, bye 4", mycustomstring.increaseDigits(2, false));


    }
    /*
      Increase Digit Test 11: Test function for empty string with wrap set to false
       */
    @Test
    public void testIncreaseDigits11() {
        mycustomstring.setString(" ");
        assertEquals(" ", mycustomstring.increaseDigits(2, false));


    }
    /*
        Increase Digit Test 12: Test function for empty string with wrap set to true
         */
    @Test
    public void testIncreaseDigits12() {
        mycustomstring.setString(" ");
        assertEquals(" ", mycustomstring.increaseDigits(9, true));


    }



    /*
         Convert Letters to Digits Test 1: middle string conversion test
     */

    @Test
    public void testConvertLettersToDigitsInSubstring1() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(19, 28);
        assertEquals("H3y, l3t'5 put 50m05 041612019 09n this 5tr1n6!11!!", mycustomstring.getString());
    }

    /*
      Convert Letters to Digits Test 2: Null pointer test
     */
    @Test(expected = NullPointerException.class)
    public void testConvertLettersToDigitsInSubstring2() {
        MyCustomString string = new MyCustomString();
        mycustomstring.convertLettersToDigitsInSubstring(200, 100);
    }
    /*
      Convert Letters to Digits Test 3: Index out of bounds test.
     */

    @Test(expected = MyIndexOutOfBoundsException.class)
    public void testConvertLettersToDigitsInSubstring3() {
        mycustomstring.setString("H3y, l3t'5 put 50me D161ts in this 5tr1n6!11!!");
        mycustomstring.convertLettersToDigitsInSubstring(200, 100);
    }


    /*
     Convert Letters to Digits Test 4: Test full string coversion
     */
    @Test
    public void testConvertLettersToDigitsInSubstring4() {
        mycustomstring.setString("Hello World");
        mycustomstring.convertLettersToDigitsInSubstring(1, 11);
        assertEquals("0805121215 2315181204", mycustomstring.getString());


    }

    /*
    Convert Letters to Digits Test 5: Test string with no letters only numbers
    */
    @Test
    public void testConvertLettersToDigitsInSubstring5() {

        mycustomstring.setString("12345678910");
        mycustomstring.convertLettersToDigitsInSubstring(1, 11);
        assertEquals("12345678910", mycustomstring.getString());

    }
 /*
    Convert Letters to Digits Test 6: Empty String test
    */

    @Test
    public void testConvertLettersToDigitsInSubstring6() {
        mycustomstring.setString(" ");
        mycustomstring.convertLettersToDigitsInSubstring(1, 1);
        assertEquals(" ", mycustomstring.getString());
    }


    /*
    Convert Letters to Digits Test 7: Test to keep end in tact.
   */
    @Test
    public void testConvertLettersToDigitsInSubstring7() {
        mycustomstring.setString("ZeroZeroTenOneTenZero");
        mycustomstring.convertLettersToDigitsInSubstring(1, 8);
        assertEquals("2605181526051815TenOneTenZero", mycustomstring.getString());


    }


    /*
        Convert Letters to Digits Test 8: Test to keep beginning in tact.
    */
    @Test
    public void testConvertLettersToDigitsInSubstring8() {
        mycustomstring.setString("123-AnotherTest");
        mycustomstring.convertLettersToDigitsInSubstring(5, 15);
        assertEquals("123-0114152008051820051920", mycustomstring.getString());



    }

    /*
        Convert Letters to Digits Test 9: Test using ***
    */
    @Test
    public void testConvertLettersToDigitsInSubstring9() {
        mycustomstring.setString("*****");
        mycustomstring.convertLettersToDigitsInSubstring(1, 4);
        assertEquals("*****", mycustomstring.getString());

    }

    /*
       Convert Letters to Digits Test 10: Test uppercase lower and symbols
   */
    @Test
    public void testConvertLettersToDigitsInSubstring10() {

        mycustomstring.setString("!H3eLL$ @W()r^lD");
        mycustomstring.convertLettersToDigitsInSubstring(1, 16);
        assertEquals("!083051212$ @23()18^1204", mycustomstring.getString());


    }

}
