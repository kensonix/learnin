package chapter8.polymorphism;

class Shape {
	public Shape(){
		System.out.println("shape before draw");
		draw();
		System.out.println("shape after draw");
	}
	public void draw(){
		System.out.println("shape drawing");
	}
} 
 public class Round extends Shape{
	private int r = 1;
	Round (){
	}
	public void draw(){
		System.out.println("round drawing and radius is " + r);
	}
	public static void main(String[] args) {
		new Round();
	}
}
