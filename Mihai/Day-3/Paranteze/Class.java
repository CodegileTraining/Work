import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Class {
	Deque<Integer> a;

	public Class() {
		a = new LinkedList<Integer>();
	}

	public void verify() {
		int ok;
		try {
			Scanner sc = new Scanner(new java.io.File("fis.in"));
			while (sc.hasNextLine()) {
				ok=1;
				String s = sc.nextLine();
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == '(') {
						a.push(1);
					}
					if (s.charAt(i) == ')') {
						if (a.isEmpty() == true){
							System.out.println("Expresia "+s+" nu este corect parantezata");
							ok=0;
							break;
						}

						else
							a.pop();
					}
				}
				if(a.isEmpty()==true && ok==1)
					System.out.println("Expresia "+s+" este corect parantezata");
			}

			sc.close();
		} catch (Exception e) {

		}
	}
	public static void main(String[] arg){
		Class ob=new Class();
		ob.verify();
	}
}
