package chapter15.generic;

public class ArrayOfGeneric {
	static final int SIZE = 100;
	static Generic<Integer>[] gia;
	
	public static void main(String[] args) {
		//运行时异常  Object cannot be cast to Generic
//		gia = (Generic<Integer>[]) new Object[SIZE];
		gia = (Generic<Integer> []) new Generic[SIZE];
		System.out.println(gia.getClass().getSimpleName());
		gia[0]= new Generic<Integer>();
//		gia[1] = new Object();
		
//		Type mismatch: cannot convert from Generic<Double> to Generic<Integer>
//		gia[2] = new Generic<Double>();
	}
}
