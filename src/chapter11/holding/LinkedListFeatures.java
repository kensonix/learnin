package chapter11.holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Integer> pets =
				new LinkedList<Integer>(Arrays .asList(1,2,3,4,5));
		System.out.println(pets + " ");
		System.out.println("pets.getFirst(): " + pets.getFirst());
		System.out.println("pets.element(): " +pets.element());
		System.out.println("pets.peak(): " +pets.peek());
		System.out.println("pets.remove(): " +pets.remove());
		System.out.println("pets.removeFirst(): " +pets.removeFirst());
		System.out.println("pets.poll(): " + pets.poll());
		System.out.println(pets);
		pets.addFirst(new Integer(33));
		System.out.println("After addFirst(): " + pets);
		Random random = new Random();
		pets.offer(random.nextInt(99));
		System.out.println("pets.offer(): " +pets);
		pets.add(random.nextInt(99));
		System.out.println("After add(): " + pets);
		pets.addLast(new Integer(100));
		System.out.println("After addLast(): " +pets);
		System.out.println("pets.removeLast(): " +pets.removeLast());
	}
}
