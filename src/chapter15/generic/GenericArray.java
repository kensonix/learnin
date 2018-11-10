package chapter15.generic;

public class GenericArray<T> {
	private T[] array;
//	@SuppressWarnings("unchecked")
	public GenericArray(int sz){
		array = (T[]) new Object[sz];
		//无法创建泛型数组
//		array = new T[sz];
	}
	public T get(int index){ return array[index];}
	public void put(int index, T item){
		array[index] = item;
	}
	public T[] rep() { return array;}
	
	public static void main(String[] args) {
		GenericArray<Integer> gai = new GenericArray<Integer>(10);
//		java.lang.Object; cannot be cast to [Ljava.lang.Integer;
//		Integer[] ia = gai.rep();
		Object[] oa = gai.rep();
	}
}
