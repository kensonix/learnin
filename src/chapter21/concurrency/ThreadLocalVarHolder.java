package chapter21.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Accessor implements Runnable{
	private final int id;
	public Accessor(int idn){
		id = idn;
	}
	public void run(){
		while(!Thread.currentThread().isInterrupted()){
			ThreadLocalVarHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}
	public String toString(){
		return "#" + id + ": " + ThreadLocalVarHolder.get();
	}
}

public class ThreadLocalVarHolder {
	private static ThreadLocal<Integer> value = 
			new ThreadLocal<Integer>(){
				private Random rand = new Random(47);
				protected synchronized Integer initialValue(){
					return rand.nextInt(1000);
				}
			};
	public static void increment(){
		 value.set(value.get() + 1);
	}
	
	public static int get(){ return value.get();}
	
	public static void main(String[] args) throws Exception{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i= 0; i < 5; i++){
			exec.execute(new Accessor(i));
		}
		TimeUnit.SECONDS.sleep(1);
		exec.shutdownNow();
	}
}
