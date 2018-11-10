package chapter14.typeinfo.toys;

interface HasBatteries{}

interface Waterproof{}

interface Shoots{}

class Toy{
//	Toy(){}
	Toy(int i){}
}

class FancyToy extends Toy implements 
	HasBatteries, Waterproof, Shoots{
	FancyToy(){super(1);}
}

public class ToyTest {
	static void printInfo(Class cc){
		System.out.println("Class name : "+ cc.getName() + " is interface? [" + cc.isInterface() +"]" );
		System.out.println("Simple name:" +cc.getSimpleName());
		System.out.println("Canonical :" + cc.getCanonicalName());
	}
	
	public static void main(String[] args) {
		Class c = null;
		try{
			c= Class.forName("chapter14.typeinfo.toys.FancyToy");
		}catch(ClassNotFoundException e){
			System.out.println("Can't find FancyToy");
			System.exit(1);
		}
//		System.out.println(c.equals(FancyToy.class));
		printInfo(c);
		for(Class face : c.getInterfaces())
			printInfo(face);
		Class up = c.getSuperclass();
		Object obj =  null;
		try{
			obj = Class.forName(up.getCanonicalName());
		}
//		catch(InstantiationException e){
//			System.out.println("Can't instantiate");
//			System.exit(1);
//		}catch(IllegalAccessException e){
//			System.out.println("Cannont access");
//			System.exit(1);
//		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printInfo(((Class)obj));
	}
}
