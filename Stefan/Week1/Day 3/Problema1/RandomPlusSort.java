import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomPlusSort {

	public static int randInt(int min, int max) {

	    Random rand = new Random();

	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	public static void BubbleSort( List<Integer> num , List<Integer> qs)
	{
	     int j;
	     boolean flag = true;   // set flag to true to begin first pass
	     int temp;   //holding variable

	     while ( flag )
	     {
	            flag= false;    //set flag to false awaiting a possible swap
	            for( j=0;  j < num.size() -1;  j++ )
	            {
	                   if ( num.get( j ) > num.get(j+1) )   // change to > for ascending sort
	                   {
	                           temp = num.get( j );                //swap elements
	                           num.set( j , num.get( j+1 ));
	                           num.set( j+1 ,temp);
	                           
	                          flag = true;              //shows a swap occurred  
	                          
	                          sort(qs,flag);
	                  } 
	            } 
	      } 
	} 
	
	public static void sort(List<Integer> values,boolean flag) {
	    // check for empty or null array
	    if (values ==null || values.size()==0){
	      return;
	    }
	    List<Integer>numbers =values;
	    int number = values.size();
	    quicksort(numbers,0, number - 1,flag);
	  }

	  private static void quicksort(List<Integer> numbers,int low, int high,boolean flag) {
	    int i = low, j = high;
	    
	    int pivot = numbers.get(low + (high-low)/2);

	    // Divide into two lists
	    while (i <= j) {
	      
	      while (numbers.get(i) < pivot) {
	        i++;
	      }
	      
	      while (numbers.get(j) > pivot) {
	        j--;
	      }

	      
	      if (i <= j) {
	        exchange(numbers,i, j);
	        i++;
	        j--;
	        if (!flag) return ;
	      }
	    }
	    // Recursion
	    if (low < j)
	      quicksort(numbers,low, j,flag);
	    if (i < high)
	      quicksort(numbers,i, high,flag);
	  }

	  private static void exchange(List<Integer> numbers,int i, int j) {
	    int temp = numbers.get(i);
	    numbers.set(i, numbers.get(j));
	    numbers.set(j, temp);
	  }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> sir1=new ArrayList<Integer>();
		
		int n=randInt(10,20);
		
		System.out.println(n);
		
		for (int i=0;i<n;i++){
			sir1.add(randInt(10,1000));
			System.out.print(sir1.get(i)+" ");
		}

		List<Integer> sir2=new ArrayList<Integer>(sir1);
		BubbleSort(sir1,sir2);
		
		System.out.println();
		for (int i=0;i<n;i++){
			
			System.out.print(sir1.get(i)+" ");
		}
		System.out.println();
		
		for (int i=0;i<n;i++){
			
			System.out.print(sir2.get(i)+" ");
		}
		
		
	}

}
