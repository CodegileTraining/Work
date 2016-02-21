import java.util.Iterator;
import java.util.List;

public class IteratorPrimUltim<T> implements Iterator<T> {

	private List<T> list;
	private int start;
	private int end;
	private boolean flag;

	public IteratorPrimUltim(List<T> list) {
		this.list = list;
		start = 0;
		end = list.size() - 1;
		flag = true;
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return start <= end;
	}

	@Override
	public T next() {
		// TODO Auto-generated method stub
		T t = null;
		if (hasNext())
			if (flag) {
				t = list.get(start++);
				flag = !flag;
			} else {
				t = list.get(end--);
				flag = !flag;
			}

		return t;
	}

}
