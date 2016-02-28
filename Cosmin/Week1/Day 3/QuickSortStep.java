package Day3;

public class QuickSortStep {

	private int left;
	private int right;
	private int[]vector;
	
	public QuickSortStep(int[] vect,int l,int r){
		this.vector=vect;
		this.left=l;
		this.right=r;
	}
	public int[] getVector(){
		return this.vector;
	}
	public int getLeft(){
		return this.left;
	}
	public int getRight(){
		return this.right;
	}
}
