package Fisier;

import java.util.List;

import Fisier.ImbricatedClasses.ClasaImbricata;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new Mylist<Integer>();
		
		list.add(23);
		list.add(34);
		list.add(45);
		
		System.out.println(list.contains(40));

		//System.out.println(Instrument.numar);
		
		NamelessClassImplementsInterface4 object=new NamelessClassImplementsInterface4();
		object.met10(object);
		
		ImbricatedClasses imbcls=new ImbricatedClasses();
		ClasaImbricata clsimb=imbcls.new ClasaImbricata();
		
	}

}
