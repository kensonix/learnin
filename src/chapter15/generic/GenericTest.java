package chapter15.generic;

public class GenericTest {
		public static <T extends Foo> void test(T t){
			t.A();
			t.B();
		}
		public static void main(String[] args) {
			test(new Bar());
		}
}
