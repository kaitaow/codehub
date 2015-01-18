package headfirst;
import java.util.*;

interface Iterator{
	public Object next();
	public boolean hasNext();
}

interface Aggregate{
	public Iterator createIterator();
}
class ConcreteAggregate<T> implements Aggregate{
	private List<T> list=new ArrayList<T>();
	public ConcreteAggregate(List<T> list){
		this.list=list;
	}
	//define the Iterator as inner class for the convenience of visiting private data fields
	public Iterator createIterator(){
		return new ConcreteIterator();
	}
	class ConcreteIterator implements Iterator{
		private int position=0;
		public Object next() {
			// TODO Auto-generated method stub
			T obj=list.get(position);
			position++;
			return obj;
		}

		public boolean hasNext() {
			// TODO Auto-generated method stub
			return position<list.size();
		}		
	}
}

public class IteratorPattern {
	public static void main(String[] args){
		List<Integer> list=new ArrayList<Integer>();
		list.add(32);
		list.add(43);
		list.add(423);
		Aggregate aggregate=new ConcreteAggregate(list);
		Iterator iterator=aggregate.createIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
