package chapter21.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Pair{
	void getX(){}
	void getY(){}
	void incrementX(){}
	void incrementY(){}
};
abstract class PairManager{
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = 
			Collections.synchronizedList(new ArrayList<Pair>());
	
	public synchronized Pair getPair(){
		return new Pair();
	}
	
	protected void store(Pair p){
		storage.add(p);
		try{
			TimeUnit.MILLISECONDS.sleep(50);
		}catch(InterruptedException e){
			
		}
	}
	public abstract void increment();
}

class ExplicitPairManager1 extends PairManager{
	private Lock lock = new ReentrantLock();
	public synchronized void increment(){
		lock.lock();
		try{
			p.incrementX();
			p.incrementY();
			store(getPair());
		}finally{
				lock.unlock();
		}
	}
}

class ExplicitPairManager2 extends PairManager{
	private Lock lock = new ReentrantLock();
	public void increment(){
		Pair temp;
		lock.lock();
		try{
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}finally{
			lock.unlock();
		}
		store(temp);
	}
}

public class ExplicitCriticalSection {
	public static void main(String[] args) throws Exception{
		PairManager 
		 pman1 =new ExplicitPairManager1(),
		pman2 =new ExplicitPairManager2();
	}
}
