package edu.gatech.seclass;

import org.junit.Test;

/**
 * Created by corey crooks on 3/28/2018.
 */
public class FlawedClassTestBC2 {

    // 100% branch coverage that reveals fault.
    @Test
    public void test1()
    {
        FlawedClass.flawedMethod2(3,3,true,true);
    }
    @Test
    public void test2()
    {
        FlawedClass.flawedMethod2(0,0,false,false);
    }
}
