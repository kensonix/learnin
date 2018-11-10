package chapter19.enumerated;

public interface Food {
 enum Appetize implements Food{
	 SALAD,SOUP,SPRING_ROLLS;
 }
 enum MainCourse implements Food{
	 LASAGNE,BURRITO,PAD_THAI;
 }
 	public class TypeOfFood{
 		public static void main(String[] args) {
			Food food = Appetize.SALAD;
			System.out.println(food);
			food = MainCourse.PAD_THAI;
			System.out.println(food);
		} 
 	}
}
