package chapter21.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SleepingTask extends LiftOff{
	public void run(){
		try{
			while(countDown -- > 0){
				System.out.println(status());
				Thread.sleep(100);
			}
		}catch(InterruptedException e){
			System.err.println("Interrupted");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++)
			exec.execute(new SleepingTask());
		exec.shutdown();
	}
}
