package edu.gatech.seclass;

/**
 * Created by corey crooks on 3/27/2018.
            */
    public class FlawedClass {


    public void flawedMethod1(int a, boolean b, boolean c) {

/*
        if (divisor == 0) throw new java.lang.ArithmeticException("Divide by zero");


          Purpose: (1)Create a test suite that achieves 100% branch coverage and does not reveal the fault.
                   (2)Every test suite that achieves 100% statement coverage reveals the fault.
          Result: This will fail due to hitting fault on branch coverage.

          Reason:
            The reason that this fails to meet 100% branch coverage is because when you evaluate the true branch, it will
            hit the fault "division by zero". If you evaluate every if statement as either true or false, the first test
            would reveal false which would give 50% coverage. When you evaluate for the other 50% by setting the divisor to 0
            you will hit the fault.


        */


    }

    //100 statement doesnt reveal, 100 branch that reveals
    public  static int flawedMethod2(int a, int divisor,  boolean b, boolean c) {

        int result = a;

        if(b){
            result =  result * 2;
        }
        if(c){
            result = result + divisor;
        }
        else{
            result = divisor / 2; // zero fault
        }
        result = result / a;
        return result;

    }


    public static int flawedMethod3(int a, boolean b, boolean c) {
        // < 100 statement that hits fault & 100% branch doesnt reveal
        int answer = a;

        if(b)
        {
            a = a * 2;
            answer = a;
            a = a - answer;
        }
        if(c){
            a = 5;
        }
        answer = answer / a; // fault
        return answer;
    }


    //100% branch doesn't reveal fault, path coverage reveals fault
    public static void flawedMethod4(int a, boolean b, boolean c) {
        // < 100 statement that hits fault & 100% branch doesnt reveal
//    int result = 10;
//
//    if(b){
//      a = 0;
//    }
//    if(c){
//        a = 0;
//    }
//
//    return result / a;


    /*
         Purpose: (1)Achieves 100% path coverage reveals the fault
                  (2)Create a test suite that achieves 100% branch coverage and does not reveal the fault
          Result: If you have 100% path coverage with a fault then you are guaranteed to hit a fault
           trying to achieve 100% branch coverage.


          Reason:
            This is not possible to achieve. When creating all of the number of paths, the fault will
            be executed. However when trying to achieve 100% branch coverage without hitting the fault
            will fail. When executing the path, your taking the cartesian product to each if statement, in
            this case would be passing
            true     true      false    false
            true     false     false    true

            Branching is similar to paths when you visualize every if statement as two branches
            (true and false). In this situation, when your showing faults for paths you are going
            to show fault for branches.


            Path Coverage -> Branch Coverage


     */
    }





    public static boolean flawedMethod5 (boolean a, boolean b) {

        int x = 2;
        int y = 4;
        if(a)
            x = 4;
        else
            y = y / x;
        if(b)
            y -= x;
        else
            x += y;
        return ((x/y)>0);
    }

// | a | b |output|
// ================
// | T | T |   E  |
// | T | F |   T  |
// | F | T |   E  |
// | F | F |   T  |
// ================
// Coverage required: Path coverage

     //Path coverage -> branch coverage -> statement coverage
    // branch testing would only test t t and f f. not t f f t etc.





















}

