package edu.neu.coe.info6205.coupon_collector_birthday_problem;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashFunctionTest {

	@Test
    public void testHash(){

        Helper help = new Helper();        
        assertEquals(help.hash(50,67), 17);
        assertEquals(help.hash(50, -0.0),0);
        assertEquals(help.hash(50, 0.0),0);
        assertEquals(help.hash(50, 64.0),4);
//        fail("The test case is a prototype.");
        
    }

}
