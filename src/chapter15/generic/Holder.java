package chapter15.generic;


//class Fruit{}
//class Apple extends Fruit{}
//class Orange extends Fruit{}
public class Holder <T>{
	private T value;
	public Holder(){}
	public Holder(T val){ value = val;}
	public void set(T val) {value = val;}
	public T get() { return value;}
	public boolean equals(Object obj){
		return value.equals(obj);
	}
	public static void main(String[] args){
		Holder<Apple> Apple = new Holder<Apple>(new Apple());
		Apple apple = Apple.get();
//		Holder<Fruit> Fruit = Apple;
		Holder<? extends Fruit> fruit = Apple;
		Fruit f = fruit.get();
		apple = (Apple)fruit.get();
		try{
//			Orange o = (Orange)fruit.get();
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println(fruit.equals(apple));
	}

}
