package chapter21.concurrency;

public class Pratice1 implements Runnable{
	public static int id = 0;
	public void run(){
		for(int i = 0; i < 3; i++){
			System.out.println(" �� " + id++ + "�ε���");
			Thread.yield();
		}
		
	}
	public static void main(String[] args) {
		for(int i = 0; i< 10; i ++){
			new Thread(new Pratice1()).start();
		}
	}
}
