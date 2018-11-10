package chapter16.container;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {
	static class ToDoItem implements Comparable<ToDoItem>{
		private char primary;
		private int secondary;
		private String item;
		public ToDoItem(String it, char pr, int sec){
			item = it;
			primary = pr;
			secondary = sec;
		}
		public int compareTo(ToDoItem arg){
			if(primary > arg.primary) 
				return +1;
			if(primary == arg.primary)
				if(secondary >arg.secondary) 
					return +1;
			if(secondary == arg.secondary) 
				return 0;
			return -1;
		}
		public String toString(){
			return Character.toString(primary) + secondary + ":" +item;
		}
	}
	public void add(String it, char pr,int sec){
		super.add(new ToDoItem(it,pr,sec));
	}
	
	public static void main(String[] args) {
		ToDoList list = new ToDoList();
		list.add("Empty trash",'c',4);
		list.add("Feed Dog",'a',2);
		list.add("Feed Bird",'b',7);
		list.add("Mow lawn",'c',3);
		list.add("Water lawn",'a',1);
		list.add("Feed cat",'b',1);
		while(! list.isEmpty())
		System.out.println(list.remove());
	}
	
}
