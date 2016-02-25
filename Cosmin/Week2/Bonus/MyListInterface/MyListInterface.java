package Week2.MyListInterface;

public interface MyListInterface<T> {

	int x=10;
   void setX();
	boolean add(T e);
	boolean remove(T e);
	boolean isEmpty();
	boolean contains(T e);
	int indexOf(T e);
	
}
