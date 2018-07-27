package edu.neu.coe.info6205.coupon_collector_birthday_problem;

public class Helper {
	
    static <Key>int hash(int M, Key key)
    {  return (key.hashCode() & 0x7fffffff) % M;  }


}
