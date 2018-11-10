package chapter15.generic;

import java.util.ArrayList;
import java.util.List;

public class FieldListMaker<T> {
	List<T> create(T t, int n){
		List<T> result = new ArrayList<T>();
		for(int i = 0; i< n; i++)
			result.add(t);
		return result;
	}
	public static void main(String[] args) {
		FieldListMaker<String> stringMaker = new FieldListMaker<String>();
		List<String> list = stringMaker.create("Hello",4);
		System.out.println(list);
	}
}
