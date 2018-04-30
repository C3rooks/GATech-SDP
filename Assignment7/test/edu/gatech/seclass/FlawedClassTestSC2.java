package edu.gatech.seclass;

import edu.gatech.seclass.FlawedClass;
import org.junit.Test;

/**
 * Created by corey crooks on 3/28/2018.
 */
public class FlawedClassTestSC2 {


    // 100% statement coverage that doesn't reveal fault
    @Test
    public void test1()
    {
        FlawedClass.flawedMethod2(3,3,true,true);
    }

    @Test
    public void test2(){
        FlawedClass.flawedMethod2(3,3,false,false);
    }
}
