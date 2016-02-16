import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class pr1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String fileName = "test.txt";
		
		String line = null;
		
        int nr_real=0;
        int nr_int=0;
        
        try {

            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	
                System.out.println(line);
                
                double x=Double.parseDouble(line);
                
                if ((int)x==(double)x)
                	nr_real++;
                else nr_int++;
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                   
            
        }
        System.out.println("Nr reale: " + nr_real);
        System.out.println("Nr intregi: " + nr_int);
	}

}
