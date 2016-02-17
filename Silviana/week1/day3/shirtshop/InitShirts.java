package shirtshop;


import java.util.HashMap;


public class InitShirts {
	public static HashMap<String,Shirt> shirts;
	public static HashMap<String,Shirt> theExistingShirts()
	{
		shirts= new HashMap<String,Shirt>();
	    shirts.put("1abc",new Shirt("1abc", "tricotat", "verde",34,0));
	    shirts.put("2abc",new Shirt("2abc", "tricotat ", "verde", 36,3));
	    shirts.put("3abc",new Shirt("3abc", "bumbac ", "albastru", 36,7));
	    shirts.put("4abc",new Shirt("4abc", "elastan ", "roz", 34,18));
	    shirts.put("5abc",new Shirt("5abc", "lana ", "negru", 42,10));
	    
		
		return shirts;
	}

}
