package Week2.Interface_Ception;

public class InterfaceCeptionClass extends ConcreteClass implements InheritInterface{

	@Override
	public void meth1() {
		System.out.println("Method1");
		
	}

	@Override
	public void meth2() {
		System.out.println("Method2");
		
	}

	@Override
	public void meth3() {
		System.out.println("Method3");
		
	}

	@Override
	public void meth4() {
		System.out.println("Method4");
		
	}

	@Override
	public void meth5() {
		System.out.println("Method5");
		
	}

	@Override
	public void meth6() {
		System.out.println("Method6");
		
	}

	@Override
	public void meth7() {
		System.out.println("Method7");
	}
	
	public void m1(Interface1 i){
		i.meth1();
	}
	public void m2(Interface2 i){
		i.meth3();
	}
	public void m3(Interface3 i){
		i.meth5();
	}
	public void m4(InheritInterface i){
		i.meth6();
	}
	
	public static void main(String[] s){
		InterfaceCeptionClass ob=new InterfaceCeptionClass();
		ob.m1(ob);
		ob.m2(ob);
		ob.m3(ob);
		ob.m4(ob);
	}
}
