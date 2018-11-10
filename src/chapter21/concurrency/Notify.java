package chapter21.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

class Blocker{
	synchronized void waitingCall(){
		try{
			while(!Thread.interrupted()){
				wait();
				System.out.print(Thread.currentThread() +" ");
			}
		}catch(InterruptedException e){
			
		}
	}
	synchronized void prod(){ notify();}
	synchronized void prodAll(){ notifyAll(); }
}

class Task implements Runnable{
	private  int i ;
	public Task(int i){ this.i = i; }
	static Blocker blocker = new Blocker();
	public void run(){
		blocker.waitingCall();
	}
}
public class Notify {
//	public static void main(String[] args) {
//		ExecutorService exec = Executors.newCachedThreadPool();
//		for(int i = 0; i < 5; i++){
//			exec.execute(new Task(i));
//		}
//		Task.blocker.prodAll();
//		
//	}
	@Test
	public void test() throws InterruptedException{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i = 0; i < 5; i++){
			exec.execute(new Task(i));
		}
		Thread.sleep(100);
		Task.blocker.prodAll();
	}
}
