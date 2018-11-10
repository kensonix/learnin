package chapter7.reusing;

 public class Frog extends Animal{
	 public void say(){
		System.out.println("this a frog");
	}
	 public static void main(String[] args) {
		 Animal animal = new Frog();
		 Animal.invoke(animal);
		}
}
 class Animal{
	 public void say(){
			System.out.println("this an Animal");
	 }
	 public static void invoke(Animal animal){
		 animal.say();
		}
	
 }
