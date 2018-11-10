package chapter10.innerclasses.pratise;

public class Outer {
	
	private static class StaticInner{
		protected void  say(){
			System.out.println("I am static inner");
		}
		public static class NextInner{
			public void say(){
				System.out.println("I am next inner");
			}
			
		}
		public static NextInner getNextInner(){
			return new NextInner();
		}
	}
	public static StaticInner getInner(){
		return new StaticInner();
	}
	
	public static void main(String[] args) {
		StaticInner inner = getInner();
		inner.say();
		inner.getNextInner().say();
	}
}
