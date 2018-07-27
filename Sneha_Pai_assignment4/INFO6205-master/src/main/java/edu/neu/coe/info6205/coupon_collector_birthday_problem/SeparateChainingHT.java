package edu.neu.coe.info6205.coupon_collector_birthday_problem;

public class SeparateChainingHT<Key, Value> {
	
	
	public static int chainCount=0;
	public static int nodeCount=0;
	
	private int M;
	private Node[] st ;
	
	
	public SeparateChainingHT(int slots)
	{
		this.M=slots;
		this.st =  new Node[M];
	}
	
	
	
	private static class Node
	{
		private Object key;
		private Object val;
		private Node next;	
		
		public Node(Object key, Object val, Node next)
		{
			this.key = key;
			this.val = val;
			this.next = next;
		}
		
	}
	
	private int hash(Key key)
	{  
//		System.out.println("key: "+key+" from hash function: "+ (key.hashCode() & 0xffffffff) % M);
		return (key.hashCode() & 0x7fffffff) % M;
		
	}

	public Value get(Key key)
	{
		int i=hash(key);
		for(Node x = st[i];x!=null; x=x.next)
		{
			if(key.equals(x.key))
				return (Value)x.val;
		}
		
		return null;
	}
	
	public void put(Key key, Value val)
	{
		int i=hash(key);
		
		nodeCount++;

		if(st[i]==null)
		{
			
			chainCount++;
		}
		
		

		for(Node x = st[i]; x!=null; x=x.next)
		{
			if(key.equals(x.key))
			{	
				x.val = val;
				return;
			}
		}
		st[i]= new Node(key,val, st[i]);
	}
	
	
	
}
