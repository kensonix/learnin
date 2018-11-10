package chapter21.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Practice2 implements Runnable {
	Random rand = new Random(System.currentTimeMillis());
	private static  int id = 0;
	public void run(){
		try {
			int sec = rand.nextInt(10000);
			Thread.sleep(sec);
			System.out.println("Thread " + id++ + " has slept " + sec +" Millseconds");
		} catch (InterruptedException e) {
			System.err.println("Interrupted!");
		}
	}
	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(10);
		for(int i = 0; i< 10; i++)
			exec.execute(new Practice2());
		exec.shutdown();
	}
}
