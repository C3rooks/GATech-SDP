package edu.gatech.seclass;

import org.junit.Test;

/**
 * Created by corey crooks on 3/28/2018.
 */
public class FlawedClassTestBC3 {

    // 100% branch coverage that does not reveals fault.
    @Test
    public void test1()
    {
        FlawedClass.flawedMethod3(3, true,true);
    }
}
