package chapter10.innerclasses.pratise;

 class TestBeded {
	private void say(){
		System.out.println("i am a");
	}
	static class Tester{
		public  void testSay() {
			TestBeded t = new TestBeded();
			t.say();
		}
	}
}

public class Beded extends TestBeded{
	public void say(){
		System.out.println("i am b");
	}
	public static void main(String[] args) {
		Tester tt = new Tester();
		tt.testSay();
	}
	
	
}
