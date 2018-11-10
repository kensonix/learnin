package chapter21.concurrency;

import java.util.concurrent.TimeUnit;

class NeedsCleanup{
	private final int id;
	public NeedsCleanup(int ident){
		id = ident;
		System.out.println("NeedsClean up " + id);
	}
	
	public void cleanup(){
		System.out.println("Cleaning up " + id);
	}
}

class Blocked3 implements Runnable{
	private volatile double d = 0.0;
	public void run(){
		try{
			while(! Thread.interrupted()){
				//point1
				NeedsCleanup n1 = new NeedsCleanup(1);
				//在定义n1后，立即执行try- finally，确保正确清理n1
				try{
					System.out.println("Sleeping");
					TimeUnit.SECONDS.sleep(1);
					//point2
					NeedsCleanup n2 = new NeedsCleanup(2);
					try{
						System.out.println("Calculating ");
						for(int i = 0; i < 250000; i++){
							d= d+ (Math.PI + Math.E) /d;
						}
						System.out.println("Finished time- consuming operation");
					}finally{
						n2.cleanup();
					}
				}finally{
					n1.cleanup();
				}
			}
					System.out.println("Exiting via while() test");
				}catch(InterruptedException e){
					System.out.println("Exiting via InterruptedException");
				}
			}
}

public class InterruptingIdiom {
	public static void main(String[] args) throws Exception{
		if(args.length != 1){
			System.out.println("usuage : java InterruuptingIdion delay-in-ms");
			System.exit(1);
		}
		Thread t = new Thread( new Blocked3());
		t.start();
		TimeUnit.MILLISECONDS.sleep(new Integer(args[0]));
		t.interrupt();
	}
}
