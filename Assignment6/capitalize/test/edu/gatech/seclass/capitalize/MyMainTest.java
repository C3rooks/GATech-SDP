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

public class MyMainTest {
	
/*
Place all  of your tests in this class, optionally using MainTest.java as an example.
*/
    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();
    private Charset charset = StandardCharsets.UTF_8;
    public int arguments = 0;

    // Purpose: Check if file exists
    // Frame #: 1
    @Test
    public void capitalizeTest1() throws Exception {
      //  File inputFile1 = createInputFile("THIS IS a simple test for counting the occurrences of a specific pattern");

        String args[] = {"-w","-m"};
        Main.main(args);

        String expected1 = "2";
        String fileName = args[0];
        File f = new File(fileName);
        if(f.exists() && !f.isDirectory()) {
            assertTrue("File exists", true);
        }else{
            assertTrue("File does not exist! ", false);
        }
    }


    // Purpose: Size of the file :  Empty
    // Frame #: 2

    @Test
    public void capitalizeTest2() throws Exception {
        File inputFile1 = createInputFile("");
        String args[] = {"-m", "CS6300", inputFile1.getPath()};
        Main.main(args);
        String actual3 = getFileContent(inputFile1.getPath());
        assertTrue("Error file is empty", actual3.length() > 0);
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
        String args[] = {};
        Main.main(args);
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

        String args[] = {"-m", " \"ASAP", inputFile1.getPath()};
        Main.main(args);

        char start = args[1].charAt(0);
        char end = args[1].charAt(args[1].length()-1);

        assertEquals("Error not enclosed quotes", start, end);
    }


    // Purpose: check if pattern has letters
    // Frame #: 7
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


        assertTrue("Error no letters in pattern", args[1].length() > expected );
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

        String args[] = {"-m", "CS6300 is the most fun course ever", inputFile1.getPath()};
        Main.main(args);
        String actual3 = getFileContent(inputFile1.getPath());
        assertTrue("Error pattern cannot be larger than the file content",args[1].length() < actual3.length());
    }


    // Purpose: -w (first flag) is not capital
    // Frame #: 11
    @Test
    public void capitalizeTest9() throws Exception {
        File inputFile1 = createInputFile("Hello world");

        String args[] = {"-W", "CS6300", inputFile1.getPath()};
        Main.main(args);

        assertTrue("Error flag is capitalized", !Character.isUpperCase(args[0].charAt(1)));

    }



    // Purpose: Check if all words are capital when all flags are present
    // Frame #: 15
    @Test
    public void capitalizeTest10() throws Exception {
        File inputFile1 = createInputFile("this is a simple test, this is for fun");
        String args[] = {"-m", "this", "-w", "t", "-f", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "tHIS IS A SIMPLE tEST, tHIS IS FOR FUN";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file does not capitalize correctly", expected3, actual3);
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
    @Test
    public void capitalizeTest12() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-m","this", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "This is another test";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
    }

    // Purpose: Test for all words flipped correctly using -m and -f
    // Frame #: 46
    @Test
    public void capitalizeTest13() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-m","this","-f", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "tHIS IS ANOTHER TEST";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
    }

    // Purpose: Test for all words flipped correctly using -w and -f with no quotes
    // Frame #: 32
    @Test
    public void capitalizeTest14() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-m","-f", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "tHIS iS aNOTHER tEST";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
    }

    // Purpose: use -w and -m with 1 char patterns to verify correct
    // Frame #: 29
    @Test
    public void capitalizeTest15() throws Exception {
        File inputFile1 = createInputFile("this is another test");
        String args[] = {"-m","i","-w","s", inputFile1.getPath()};
        Main.main(args);
        String expected3 = "ThIs Is another test";
        String actual3 = getFileContent(inputFile1.getPath());
        assertEquals("The file has not been capitalized correctly!", expected3, actual3);
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