package edu.gatech.seclass.capitalize;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//Total 6 found bugs. Type 
public class MyMainTest {
	
/*
Place all  of your tests in this class, optionally using MainTest.java as an example.
*/
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private Charset charset = StandardCharsets.UTF_8;
    public int arguments = 0;
    private  ByteArrayOutputStream outStream;
    private  ByteArrayOutputStream errStream;
    private  PrintStream outOrig;
    private  PrintStream errOrig;

 private File createInputFile3() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!");

        fileWriter.close();
        return file1;
    }

      @Test
    public void mainTest1() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {inputFile1.getPath()};
        Main.main(args);

        String expected1 = "Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "Take 2 courses so that I will graduate Asap!";

        String actual1 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected1, actual1);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 2 from assignment directions
    @Test
    public void mainTest2() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-w", inputFile1.getPath()};
        Main.main(args);

        String expected2 = "Howdy Billy,\n" +
                "I Am Going To Take Cs6300 And Cs6400 Next Semester.\n" +
                "Did You Take Cs 6300 Last Semester? I Want To\n" +
                "Take 2 Courses So That I Will Graduate Asap!";

        String actual2 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected2, actual2);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 3 from assignment directions
    @Test
    public void mainTest3() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-m", "CS6300", inputFile1.getPath()};
        Main.main(args);

        String expected3 = "Howdy Billy,\n" +
                "I am going to take CS6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!";

        String actual3 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected3, actual3);
    }


     // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 4 from assignment directions
    @Test
    public void mainTest4() throws Exception {
        File inputFile2 = createInputFile5();

        String args[] = {"-m", "AAAA", inputFile2.getPath()};
        Main.main(args);

        String expected4 = "AAAAaa";

        String actual4 = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected4, actual4);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 5 from assignment directions
    @Test
    public void mainTest5() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-m", "ASAP", "-f", inputFile1.getPath()};
        Main.main(args);

        String expected5 = "hOWDY bILLY,\n" +
                "i AM GOING TO TAKE CS6300 AND CS6400 NEXT SEMESTER.\n" +
                "dID YOU TAKE CS 6300 LAST SEMESTER? i WANT TO\n" +
                "TAKE 2 COURSES SO THAT i WILL GRADUATE asap!";

        String actual5 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected5, actual5);
    }

    // Purpose: To provide an example of a test case format
    // Frame #: Instructor example 6 from assignment directions
    @Test
    public void mainTest6() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-w", "abc", inputFile1.getPath()};
        Main.main(args);

        String expected6 = "Howdy Billy,\n" +
        "I aM going to taKe cS6300 aNd cS6400 next semester.\n" +
                "Did you taKe cS 6300 laSt semester? I waNt to\n" +
                "taKe 2 cOurses so thaT I will graDuaTe AsaP!";

        String actual6 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected6, actual6);
    }


    // Purpose: To provide an example of a test case format
    // Frame #: Instructor error example
    @Test
    public void mainTest7() {
        String args[] = null; //invalid argument
        Main.main(args);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest8() {
        String args[] = {"-m"}; //invalid argument
        Main.main(args);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest9() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-i", inputFile1.getPath()};
        Main.main(args);

        String expected = "howdy billy,\n" +
                "i am going to take cs6300 and cs6400 next semester.\n" +
                "did you take cs 6300 last semester? i want to\n" +
                "take 2 courses so that i will graduate asap!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest10() throws Exception {
        File inputFile3 = createInputFile4();

        String args[] = {"-I", inputFile3.getPath()};
        Main.main(args);

        String expected = "HOWDY BILLY,\n" +
                "I AM GOING TO TAKE CS6300 AND CS6400 NEXT SEMESTER.\r\n" +
                "DID YOU TAKE CS 6300 LAST SEMESTER? I WANT TO\r" +
                "TAKE 2 COURSES SO THAT I WILL GRADUATE ASAP!";

        String actual = getFileContent(inputFile3.getPath());

        assertEquals("The files differ!", expected, actual);
    }


// 4 = 6 
 private File createInputFile6() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!");

        fileWriter.close();
        return file1;
    }



    @Test
    public void mainTest11() throws Exception {
        File inputFile4 = createInputFile14();

        String args[] = {"-o", "-f", inputFile4.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!";

        String actual = getFileContent(inputFile4.getPath());

        assertEquals("The file was changed!", expected, actual);

        assertEquals("hOWDY bILLY,\n" +
                "tHIS IS A TEST FILE FOR THE CAPITALIZE UTILITY.\n" +
                "LET'S MAKE SURE IT HAS AT LEAST A FEW LINES,\n" +
                "SO THAT WE CAN CREATE SOME \n"
                + "INTERESTING TEST CASES...aND LET'S SAY \"HOWDY\" TO bILL AGAIN!", outStream.toString().trim());
    }


    @Test
    public void mainTest12() throws Exception {
        File inputFile5= createInputFile15();

        String args[] = {inputFile5.getPath()};
        Main.main(args);

        String expected = "Bill is," + System.getProperty("line.separator") +
                "In my opinion," + System.getProperty("line.separator") +
                "An easier name to spell than William." + System.getProperty("line.separator") +
                "Bill is shorter," + System.getProperty("line.separator") +
                "And Bill is" + System.getProperty("line.separator") +
                "First alphabetically.";

        String actual = getFileContent(inputFile5.getPath());

        assertEquals("The files differ!", expected, actual);
    }

       // Purpose: Additional D2 Test
    @Test
    public void mainTest13() throws Exception {
        File inputFile7 = createInputFile17();

        String args[] = {"-w", "\\?", inputFile7.getPath()};
        Main.main(args);

        String expected = "123\\456?789\\0ab?Cde\\Fgh?Ijk\\Lmn?Opq\\Rst?Uvw\\Xyz";

        String actual = getFileContent(inputFile7.getPath());

        assertEquals("The files differ!", expected, actual);
    }



   // Purpose: Additional D2 Test
    @Test
    public void mainTest14() throws Exception {
        File inputFile8 = createInputFile18();

        String args[] = {"-w", "|", "-f", "-m", "XYZ", inputFile8.getPath()};
        Main.main(args);

        String expected = "123|456|789|0AB|cDE|fGH|iJK|lMN|oPQ|rST|uVW|xyz";

        String actual = getFileContent(inputFile8.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest15() throws Exception {
        File inputFile6 = createInputFile16();

        String args[] = {"-m", "ABC'S", "-w", inputFile6.getPath()};
        Main.main(args);

        String expected = "Howdy Bill, Have You Learned Your Abc And 123?\r\n" +
                "I Know My ABC'S.\r" +
                "It Is Important To Know Your ABC'S And 123's,\n" +
                "So Repeat With Me: Abc! 123! Abc And 123!";

        String actual = getFileContent(inputFile6.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest16() throws Exception {
        String args[] = {"nofile.txt"};
        Main.main(args);

        assertEquals("File Not Found", errStream.toString().trim());
    }


 // Purpose: Additional D2 Test
    @Test
    public void mainTest17() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-f", "-x", inputFile1.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The file was changed!", expected, actual);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest18() throws Exception {
        File inputFile6 = createInputFile16();

        String args[] = {"-f", "-I", inputFile6.getPath()};
        Main.main(args);

        String expected = "howdy bill, have you learned your abc and 123?\r\n" +
                "i know my abc's.\r" +
                "it is important to know your abc's and 123's,\n" +
                "so repeat with me: abc! 123! abc and 123!";

        String actual = getFileContent(inputFile6.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest19() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-w", "abc", inputFile1.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "I aM going to taKe cS6300 aNd cS6400 next semester.\n" +
                "Did you taKe cS 6300 laSt semester? I waNt to\n" +
                "taKe 2 cOurses so thaT I will graDuaTe AsaP!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }



    // Purpose: Additional D2 Test
    @Test
    public void mainTest20() throws Exception {
        File inputFile3 = createInputFile13();

        String args[] = {"-f", "-f", "-f", inputFile3.getPath()};
        Main.main(args);

        String expected = "hOWDY bILLY,\n" +
                "i AM GOING TO TAKE CS6300 AND CS6400 NEXT SEMESTER.\r\n" +
                "dID YOU TAKE CS 6300 LAST SEMESTER? i WANT TO\r" +
                "TAKE 2 COURSES SO THAT i WILL GRADUATE aSAP!";

        String actual = getFileContent(inputFile3.getPath());

        assertEquals("The files differ!", expected, actual);
    }






// Purpose: Additional D2 Test
    @Test
    public void mainTest21() throws Exception {
        File inputFile1 = createInputFile3();

        String args[] = {"-w", "a", "-w", "bc",  inputFile1.getPath()};
        Main.main(args);

        String expected = "Howdy Billy,\n" +
                "I aM going to taKe cS6300 aNd cS6400 next semester.\n" +
                "Did you taKe cS 6300 laSt semester? I waNt to\n" +
                "taKe 2 cOurses so thaT I will graDuaTe AsaP!";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest22() throws Exception {
        File inputFile5 = createInputFile15();

        String args[] = {"-w", "z", inputFile5.getPath()};
        Main.main(args);

        String expected = "Bill is," + System.getProperty("line.separator") +
                "in my opinion," + System.getProperty("line.separator") +
                "an easier name to spell than William." + System.getProperty("line.separator") +
                "Bill is shorter," + System.getProperty("line.separator") +
                "and Bill is" + System.getProperty("line.separator") +
                "first alphabetically.";

        String actual = getFileContent(inputFile5.getPath());

        assertEquals("The files differ!", expected, actual);
    }


  // Purpose: Additional D2 Test
    @Test
    public void mainTest23() throws Exception {
        File inputFile9 = createInputFile19();

        String args[] = {"-f", inputFile9.getPath()};
        Main.main(args);

        String expected = " ";

        String actual = getFileContent(inputFile9.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest24() throws Exception {
        File inputFile7 = createInputFile17();

        String args[] = {"-w", inputFile7.getPath()};
        Main.main(args);

        String expected = "123\\456?789\\0ab?cde\\fgh?ijk\\lmn?opq\\rst?uvw\\xyz";

        String actual = getFileContent(inputFile7.getPath());

        assertEquals("The files differ!", expected, actual);
    }

    // Purpose: Additional D2 Test
    @Test
    public void mainTest25() throws Exception {
        File inputFile2 = createInputFile12();

        String args[] = {"-w", "-f", inputFile2.getPath()};
        Main.main(args);

        String expected = "aAAAAA";

        String actual = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected, actual);
    }


       // Purpose: Additional D2 Test
    @Test
    public void mainTest26() throws Exception {
        File inputFile2 = createInputFile12();

        String args[] = {"-m", "-f", inputFile2.getPath()};
        Main.main(args);

        String expected = "AAAAAA";

        String actual = getFileContent(inputFile2.getPath());

        assertEquals("The files differ!", expected, actual);
    }
 

    @Test
    public void mainTest27() throws Exception {
        File inputFile1 = createInputFile("TRYING TO GET COVERAGE");

        String args[] = {" ",  inputFile1.getPath()};
        Main.main(args);

        String expected = "TRYING TO GET COVERAGE";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }




    // Purpose: Additional D2 Test
    @Test
    public void mainTest30() throws Exception {
        File inputFile1 = createInputFile(" ");

        String args[] = {" ", inputFile1.getPath()};
        Main.main(args);

        String expected = " ";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }


    // Purpose: Additional D2 Test
    @Test
    public void mainTest28() throws Exception {
        File inputFile1 = createInputFile("this is a test");

        String args[] = {"-m", "-m", "-m", inputFile1.getPath()};
        Main.main(args);

        String expected = "this is a test";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }


    // Purpose: Additional D2 Test
    @Test
    public void mainTest29() throws Exception {
        File inputFile1 = createInputFile("this is a test");

        String args[] = {"-f", "-f", "-f", inputFile1.getPath()};
        Main.main(args);

        String expected = "THIS IS A TEST";

        String actual = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected, actual);
    }

















   private File createInputFile19() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write(" ");

        fileWriter.close();
        return file1;
    }







    private File createInputFile12() throws Exception {
        File file2 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file2);

        fileWriter.write("aaaaaa");

        fileWriter.close();
        return file2;
    }






   private File createInputFile13() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\r\n" +
                "Did you take cs 6300 last semester? I want to\r" +
                "take 2 courses so that I will graduate Asap!");

        fileWriter.close();
        return file1;
    }





    private File createInputFile16() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Bill, have you learned your abc and 123?\r\n" +
                "I know My Abc's.\r" +
                "It is important to know your abc's and 123's,\n" +
                "so repeat with me: abc! 123! Abc and 123!");

        fileWriter.close();
        return file1;
    }







    private File createInputFile18() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("123|456|789|0ab|cde|fgh|ijk|lmn|opq|rst|uvw|xyz");

        fileWriter.close();
        return file1;
    }



    private File createInputFile15() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Bill is," + System.getProperty("line.separator") +
                "in my opinion," + System.getProperty("line.separator") +
                "an easier name to spell than William." + System.getProperty("line.separator") +
                "Bill is shorter," + System.getProperty("line.separator") +
                "and Bill is" + System.getProperty("line.separator") +
                "first alphabetically.");

        fileWriter.close();
        return file1;
    }

//original 7
    private File createInputFile17() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("123\\456?789\\0ab?cde\\fgh?ijk\\lmn?opq\\rst?uvw\\xyz");

        fileWriter.close();
        return file1;
    }





// original 4 
    private File createInputFile14() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "This is a test file for the capitalize utility.\n" +
                "let's make sure it has at least a few lines,\n" +
                "so that we can create some \n"
                + "interesting test cases...And let's say \"howdy\" to Bill again!");

        fileWriter.close();
        return file1;
    }





































        private File createInputFile4() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("Howdy Billy,\n" +
                "I am going to take cs6300 and cs6400 next semester.\r\n" +
                "Did you take cs 6300 last semester? I want to\r" +
                "take 2 courses so that I will graduate Asap!");

        fileWriter.close();
        return file1;
    }

    private File createInputFile5() throws Exception {
        File file2 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file2);

        fileWriter.write("aaaaaa");

        fileWriter.close();
        return file2;
    }














    // Purpose: Check if file exists
    // Frame #: 

    //Type B
    // This is not returning the right result. The expected is 
    // [Error file not present]> but was:<[Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>]>

    @Test
    public void capitalizeTest1() throws Exception {
      //  File inputFile1 = createInputFile("THIS IS a simple test for counting the occurrences of a specific pattern");
        File inputFile1 = createInputFileSpecificText("another wonderful test of a pattern");

        String args[] = {"-w","-m"," "};
        Main.main(args);
        String expected1 = "2";
        String fileName = args[0];

       // assertEquals( "test.txt", Main.GetFile());
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }





    // Purpose: Size of the file :  Empty
    // Frame #: 2

    @Test
    public void capitalizeTest2() throws Exception {
        File inputFile1 = createInputFile("d");
        String args[] = {"-m", "CS6300", inputFile1.getPath()};
        Main.main(args);
        String actual3 = getFileContent(inputFile1.getPath());
        assertTrue("Error file is  empty", actual3.length() > 0);

    }


    // Purpose: To check the amount of words in the file
    // Frame #: 4
    @Test
    public void capitalizeTest3() throws Exception {
        File inputFile1 = createInputFile("hello");

        int actual3 = countWordAmount(inputFile1);
        int expected3 = 1;
        assertEquals("The word count is different", expected3, actual3);
    }


    // Purpose: Test for number of arguments submitted
    // Frame #: 5
    @Test
    public void capitalizeTest4() throws Exception {
        File inputFile1 = createInputFile("HELLO WORLD");
        String args[] = {"-w,-f"};
        Main.main(args);
        File f = new File(".txt");
        assertTrue("ERROR, No arguments passed", args.length > 0);
    }

    // Purpose: Presence of enclosed quotes
    // Frame #: 6
    @Test
    public void capitalizeTest5() throws Exception {
        File inputFile1 = createInputFile("Howdy Billy,\n" +
                "I am going to take CS6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!");

        String args[] = {"-m", " \"ASAP\" ", inputFile1.getPath()};
        Main.main(args);

        char start = args[1].charAt(0);
        char end = args[1].charAt(args[1].length()-1);

        assertEquals("Error not enclosed quotes", start, end);
    }


    // Purpose: check if pattern has letters
    // Frame #: 7

    //Type C 
    // Failure due to the passing arguments of  "\"\"". It will throw a runtime exception. 
    // If you pass \\abcs that will work but not the following. 
    @Test
    public void capitalizeTest6() throws Exception {
        File inputFile1 = createInputFile("Howdy Billy,\n" +
                "I am going to take CS6300 and cs6400 next semester.\n" +
                "Did you take cs 6300 last semester? I want to\n" +
                "take 2 courses so that I will graduate Asap!");

        String args[] = {"-m", "\"\"", inputFile1.getPath()};
        Main.main(args);

        char start = args[1].charAt(0);
        char end = args[1].charAt(args[1].length()-1);
        int expected = 0;
        char v = '\"';
        if(start== v && end == v)
            expected = 4;


        assertTrue( args[1].length() < expected );
    }



    // Purpose: Have all the letters for -f become flipped
    // Frame #: 8
    @Test
    public void capitalizeTest7() throws Exception {
        File inputFile1 = createInputFile("hello world");

        String args[] = {"-f", inputFile1.getPath()};
        Main.main(args);

        String expected3 = "HELLO WORLD";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The words have not been flipped", expected3, actual3);
    }



    // Purpose: Pattern size > than file content size.
    // Frame #: 10
    @Test
    public void capitalizeTest8() throws Exception {
        File inputFile1 = createInputFile("Hello");

        String args[] = {"-m", "CS", inputFile1.getPath()};
        Main.main(args);
        String actual3 = getFileContent(inputFile1.getPath());
        assertTrue("Error pattern cannot be larger than the file content",args[1].length() < actual3.length());

    }


    // Purpose: -w (first flag) is not capital
    // Frame #: 11
    @Test
    public void capitalizeTest9() throws Exception {
        File inputFile1 = createInputFile("Hello world");

        String args[] = {"-w", "CS6300", inputFile1.getPath()};
        Main.main(args);

        assertTrue("Error flag is capitalized", !Character.isUpperCase(args[0].charAt(1)));

    }



    // Purpose: Check if all words are capital when all flags are present
    // Frame #: 15

    //Type C:
    //Bug by not capitalizing this. 
    // Also Type B: Does not capitalize the first letter when string is terminated by "t" from -w 
    
    @Test
    public void capitalizeTest10() throws Exception {
        File inputFile1 = createInputFile("this is a simple test, this is for fun");
        String args[] = {"-m", "this", "-w", "t", "-f", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "this IS A SIMPLE TeST, this IS FOR FUN";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file does not capitalize correctly", expected3, actual3);

        //THIS is a simple test, this is for fun
        // 
    }


    // Purpose: Test for all words flipped correctly
    // Frame #: 51
    @Test
    public void capitalizeTest11() throws Exception {
        File inputFile1 = createInputFile("HELlo World");
        String args[] = {"-f", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "helLO wORLD";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been flipped correctly!", expected3, actual3);
    }

    // Purpose: Test for all words flipped correctly using -m
    // Frame #: 48

    //Type C:
    //Bug by not capitalizing this. completely ignoring the argument of this. 
    @Test
    public void capitalizeTest12() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-m","this", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "THIS is another test";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
    }

    // Purpose: Test for all words flipped correctly using -m and -f
    // Frame #: 46
    // Type C: 
    // Bug. Not capitalizing the matching "this" 
    // after -m = THIS is another test
    // after -f = this IS ANOTHER TEST 
    @Test
    public void capitalizeTest13() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-m","this","-f", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "this IS ANOTHER TEST";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
       
        
    }

    // Purpose: Test for all words flipped correctly using -w and -f with no quotes
    // Frame #: 32
    @Test
    public void capitalizeTest14() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-w","-f", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "tHIS iS aNOTHER tEST";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
    }

    // Purpose: use -w and -m with 1 char patterns to verify correct
    // Frame #: 29

    // Type B
    // Wrong expected output, written in test.
    // Did not capitalize first letter of word when -w "s" being terminated.
    // However still should be an error do to the I not capitalizing. 
    // expected: <Th[I]s is another tesT> but was:<Th[i]s is another tesT> 
    @Test
    public void capitalizeTest15() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-m","i","-w","s", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "This is another tesT";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
        //thIs Is another test
        // thIS IS another teSt

    }




    //Additional 15 Tests Here.


    // Frame #: 54
    @Test
    public void capitalizeTest16() throws Exception {
        File inputFile1 = createInputFile1();
        String args[] = {inputFile1.getPath()};
        Main.main(args);

        String expected6 = "This is a wonderful t3sT to show *the capital letters *";

        String actual6 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected6, actual6);
    }

    // Frame #: 57
    // Test Error handling on file and pattern only.

    //Type A: 
    // expected:<...]] [-m string] [-f] [<filename>, Missing Flag]> but was:<...]] [-m string] [-f] [[-i|-I] [-o] <filename>]>
    // from original tests. not updated to handle -o, assumed Missing Flag statement
    @Test
    public void capitalizeTest17() throws Exception {
        File inputFile1 = createInputFile1();
        String args[] = {inputFile1.getPath(), "ABCD"};
        Main.main(args);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }

    // Frame #: 53
    // Test Handling file with no normal alphabet
    @Test
    public void capitalizeTest18() throws Exception {
        File inputFile1 = createInputFileSpecificText("**1234\n 8%728^&");
        String args[] = {inputFile1.getPath()};
        Main.main(args);

        String expected6 = "**1234\n 8%728^&";

        String actual6 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected6, actual6);
    }


    // Frame #: 50
    // Test Handling file errors flip and pattern.
    @Test
    public void capitalizeTest19() throws Exception {
        File inputFile1 = createInputFileSpecificText("Test");
        String args[] = {"-f",  inputFile1.getPath()};
        Main.main(args);
        String expected6 = "tEST";

        String actual6 = getFileContent(inputFile1.getPath());

        assertEquals("The files differ!", expected6, actual6);
    }

    // Frame #: 49
    // Test finding word with quotes and capitalizing


    // Type C: 
    // There is a bug. The result should be whats expected but the code results in 
    // WONDERFUL TEST OF ABCD. It appears to ignore the quoted string. 

    @Test
    public void capitalizeTest20() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of \"abcd\"");
        String args[] = {"-m", "\"abcd\"", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "another wonderful test of \"ABCD\"";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
    }



    // Frame #: 47
    // Test finding word with quotes and flipping
    // Type C: 
    // There is a bug. The result should be whats expected but the code results in 
    // WONDERFUL TEST OF ABCD. Does not flip abcd correcly in quotes. 
    @Test
    public void capitalizeTest21() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of \"abcd\"");
        String args[] = {"-m", "\"abcd\"", "-f", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "ANOTHER WONDERFUL TEST OF \"abcd\"";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
        // another wonderful test of ABCD
        // ANOTHER WONDERFUL TEST OF abcd 
    }


    // Frame #: 45
    // Test finding word with quotes and flipping
     // Type B
    // Wrong expected output. Same as test23, not considered when writing the test expected to take into consideration
    // for -w "some args" where the some args would cap each letter if termed 
   
    @Test
    public void capitalizeTest22() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of \"a pattern\"");
        String args[] = {"-w", "ab", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "Another wonderful test of \"a paTtern\"";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
    }


    // Frame #: 39
    // Test finding word with no quotes and pattern found
    // Type B
    // Wrong expected output. Same as test24, not considered when writing the test expected to take into consideration
    // for -w "some args" where the some args would cap each letter if termed 
   
    @Test
    public void capitalizeTest23() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of a pattern");
        String args[] = {"-w", "ab", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "Another wonderful test of a paTtern";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
    }



    // Frame #: 37
    // Test using -w and -f with quotes
    // Type B
    // Wrong expected output. Same as test25, not considered when writing the test expected to take into consideration
    // for -w "some args" where the some args would cap each letter if termed 
   
    @Test
    public void capitalizeTest24() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of \"a pattern\"");
        String args[] = {"-w", "\"ab\"", "-f", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "aNOTHER WONDERFUL TEST OF \"a PAtTERN\"";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
    }


    // Frame #: 33
    // Test using -w and -f with no quotes, given a pattern, file does not have pattern.. Should flip all.

    // Type B
    // Wrong expected output. Same as test26, not considered when writing the test expected to take into consideration
    // for -w "some args" where the some args would cap each letter if termed 
    @Test
    public void capitalizeTest25() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of a pattern");
        String args[] = {"-w", "Zki", "-f", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "aNOTHER WONDERFUL TEST OF A PATTERN";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
    }


    // Frame #: 27
    // Test using -w and -m with pattern of both enclosed quotes, both patterns found.
     // Type B
    // Wrong expected output. Same as test27, not considered when writing the test expected to take into consideration
    // for -w "some args" where the some args would cap each letter if termed 
   
    @Test
    public void capitalizeTest26() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of \"a pattern\"");
        String args[] = {"-w", "\"e\"", "-m","of", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "AnotheR wondeRful teSt of \"A patteRn\"";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
    }


    // Frame #: 21
    // Test using -w, -m, and -f  with enclosed quotes where m contains pattern and w contains pattern.
    // Type B
    // Wrong expected output. Same as test28, not considered when writing the test expected to take into consideration
    // for -w "some args" where the some args would cap each letter if termed 
    @Test
    public void capitalizeTest27() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of \"a pattern\"");
        String args[] = {"-w", "\"e\"", "-m","of", "-f", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "aNOTHEr WONDErFUL TEsT OF \"a PATTErN\"";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
    }


    // Frame #: 17
    // Test using -w, -m, and -f  with no enclosed quotes where m contains pattern and w contains pattern.

    // Type B
    // Wrong expected output. Did not take into first character capped
    @Test
    public void capitalizeTest28() throws Exception {
        File inputFile1 = createInputFileSpecificText("another wonderful test of \"a pattern\"");
        String args[] = {"-w", "e", "-m","of", "-f", inputFile1.getPath()};
        Main.main(args);
        String expected6 = "aNOTHEr WONDErFUL TEsT OF \"A PATTErN\"";
        String actual6 = getFileContent(inputFile1.getPath());
        assertEquals("The files differ!", expected6, actual6);
        //anothEr wondErful tEst of "a pattern" 
        //anothEr wondErful tEst OF "a pattern" 
        //ANOTHeR WONDeRFUL TeST of "A PATTERN"
    }


    // Frame #: 12
    // Test empty pattern

    // Type B
    // expected:<[Error Empty Pattern]> but was:<[Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>]>
    @Test
    public void capitalizeTest29() throws Exception {
        File inputFile1 = createInputFile1();
        String args[] = {"-w", " ", inputFile1.getPath(), "another wonderful test of \"a pattern\""};
        Main.main(args);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }




    //not from frame
    //Test error for -f placement

    // Type B
    // expected:<[Error -f must not come before any other flags.]> but was:<[Usage: Capitalize  
    // [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>]>


    @Test
    public void capitalizeTest30() throws Exception {
        File inputFile1 = createInputFile1();
        String args[] = {"-f", "-w", inputFile1.getPath(), "another wonderful test of \"a pattern\""};
        Main.main(args);
        assertEquals("Usage: Capitalize  [-w [string]] [-m string] [-f] [-i|-I] [-o] <filename>", errStream.toString().trim());
    }





    @Before
    public  void setUp() throws Exception {
        outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        errStream = new ByteArrayOutputStream();
        PrintStream err = new PrintStream(errStream);
        outOrig = System.out;
        errOrig = System.err;
        System.setOut(out);
        System.setErr(err);
    }











    private int countWordAmount(File file) throws IOException {

      ;
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);

        String line;

        // Initializing counters
        int countWord = 0;


        // Reading line by line from the
        // file until a null is returned
        while((line = reader.readLine()) != null)
        {

            if(!(line.equals("")))
            {

                String[] wordList = line.split("\\s+");

                countWord += wordList.length;

            }
        }

        return countWord;


    }


    private File createInputFileSpecificText(String text) throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write(text);

        fileWriter.close();
        return file1;
    }


    private File createInputFile1() throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write("This is a wonderful t3sT to show *the capital letters *");

        fileWriter.close();
        return file1;
    }

    private File createInputFile(String s) throws Exception {
        File file1 =  createTmpFile();
        FileWriter fileWriter = new FileWriter(file1);

        fileWriter.write(s);

        fileWriter.close();
        return file1;
    }
    private File createTmpFile() throws IOException {
        File tmpfile = temporaryFolder.newFile();
        tmpfile.deleteOnExit();
        return tmpfile;
    }

    private String getFileContent(String filename) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(filename)), charset);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}


// Purpose: <concise description of the purpose of the test>
// Frame #: <test case number in the catpart.txt.tsl of Part I>
//capitalizeTest1, capitalizeTest2