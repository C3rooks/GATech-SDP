package edu.gatech.seclass;

import org.junit.Test;

/**
 * Created by corey crooks on 3/28/2018.
 */
public class FlawedClassTestSC3 {

    // < 100% statement coverage that reveals fault
    @Test
    public void test1()
    {
        FlawedClass.flawedMethod3(3,true,false);
    }
}
