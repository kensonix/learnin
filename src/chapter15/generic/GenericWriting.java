package chapter15.generic;

import java.util.ArrayList;
import java.util.List;

class Fruit{}
class Apple extends Fruit{}

public class GenericWriting {
	static List<Apple> apples = new ArrayList<Apple>();
	static List<Fruit> fruit = new ArrayList<Fruit>();
 	static <T> void writeExact(List<T> list, T item){
		list.add(item);
		System.out.println(list.toString());
		fruit.add(new Apple());
	}
	
	static <T> void writeWithWildCard(List<? super T> list, T item){
		list.add(item);
		System.out.println(list.toString());
	}
	static void f1(){
		writeExact(apples, new Apple());
		writeExact(fruit, new Apple());
	}
	static void f2(){
		writeWithWildCard(apples,new Apple());
		writeWithWildCard(fruit,new Apple());
	
	}
	public static void main(String[] args) {
		f1();
		f2();
	}
}
