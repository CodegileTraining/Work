package Week2.NestedClass;

import Week2.NestedClass.Nest.InnerPublic;

public class Test {

	public static void main(String[] args)
	{
		Nest n=new Nest();

		n.getInnerClassMember();
		InnerPublic in=n.new InnerPublic();
		in.setOuterClassMember(10);
		in.getOuterClassMember();
	}
}
