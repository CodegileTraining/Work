
public class MyClass {

	public static void main(String[] args) {
		
		Class outerClass = new Class();
		Class.InnerClass innerClass = outerClass.new InnerClass();
	 System.out.println(innerClass.getName());
	 //System.out.println(outerClass.getNum());
		
	}
}
