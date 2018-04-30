package edu.gatech.seclass;

import org.junit.Test;

/**
 * Created by corey crooks on 3/28/2018.
 */

//guarantees 100% coverage revealing fault.
public class FlawedClassTestXC5 {

    @Test
    public void test1(){
        FlawedClass.flawedMethod5(true,false);
    }
    @Test
    public void test2()
    {
        FlawedClass.flawedMethod5(false,true);
    }
    @Test
    public void test3()
    {
        FlawedClass.flawedMethod5(false,false);
    }
    @Test
    public void test4()
    {
        FlawedClass.flawedMethod5(true,true);
    }
}
