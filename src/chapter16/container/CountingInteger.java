package chapter16.container;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.ListIterator;

public class CountingInteger extends AbstractList<Integer>{
	private int size;
	public CountingInteger(int size){
		this.size = size < 0?0: size;
	}
	public Integer get(int index){
		return Integer.valueOf(index);
	}
	public int size(){
		return size;
	}
	public static void main(String[] args) {
		System.out.println(new CountingInteger(30));
		ArrayList al = new ArrayList();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		ListIterator listIterator = al.listIterator();
		System.out.println(listIterator.next());
				
		
	}
}
