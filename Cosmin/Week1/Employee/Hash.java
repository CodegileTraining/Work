

public class Hash {

	public static void paramTest(int x, Produs p){
		
		p.setCuloare("Test");
		p.setDescriere("Test");
		p.setDimensiune("Test");
		
		p=new Produs(1,  "TEST2", "TEST2", "TEST2");
		x=10;
	}
	
	
	public static void main(String[] args) {
		
		Produs p1=new Produs(1, "descriere", "culoare", "dimen");
		int x=1;
		System.out.println("Main: x="+x+" , Produs="+p1);
		paramTest(x, p1);
		System.out.println("After paramTest: x="+x+" , Produs="+p1);
		System.out.println("X ar trebui sa aiba aceeasi valoare din main deoarece se transmite prin valoare.\nIn cazul obiectelor catre funtie se transmite referinta catre obiect,deci obiectul ar trebui sa se modifice.Insa nu putem schimba zona de memorie alocata");
//		Produs p2=p1;
//		if(p2.equals(p1)){
//			System.out.println("Obiecte egale findca impart aceeasi zona de memorie\n"+p1.hashCode()+" -- "+p2.hashCode());
//		}
//		Produs p3=new Produs(1, "descriere", "culoare", "dimen");
//		
//		if(p3.equals(p1))
//		{
//			System.out.println("Nu ar trebui sa afiseze asta!");
//		}
//		else
//			System.out.println("Obiectele nu sunt egale dar pot avea  acelasi hashCode\n"+p1.hashCode()+" --- "+ p2.hashCode());
//		
//		Produs p4=new Produs(2, "saffasfasS", "cafasfSuloare", "dimen");
//		System.out.println(p1.hashCode()+" -- "+p4.hashCode());
		
		
		
			

	}

}
