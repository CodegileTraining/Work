package problem7;

import org.omg.Messaging.SyncScopeHelper;

/**
 * This example shows that an inner class has access to the elements of it's
 * outer class. The reverse is not true because the elements in the inner class
 * cannot be accesed from the outerclass because of the principle of
 * encapsulation.
 * 
 * @author Silviana
 *
 */
public class OuterClass {

	private int x = 0;

	class InnerClass {
		public int x = 1;

		public void printTest(int x) {
			System.out.println("new x: " + x);
			System.out.println("InnerClass x: " + this.x);
			System.out.println("OuterClass x: " + OuterClass.this.x);
		}
	}

	public static void main(String[] args) {
		OuterClass c = new OuterClass();
		OuterClass.InnerClass ob = c.new InnerClass();
		ob.printTest(2);
	}

}
