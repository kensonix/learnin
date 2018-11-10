package chapter5.initialization;

class Bowl{
	Bowl(int maker){
		System.out.println("Bowl" +maker +")");
	}
	void f1(int maker){
		System.out.println("f1("+maker+")");
	}
}
class Table{
	static Bowl bowl1 = new Bowl(1);
	public Table(){
		System.out.println("Table()");
		bowl2.f1(1);
	}
	void f2(int maker){
		System.out.println("f2("+maker+")");
	}
	static Bowl bowl2 = new Bowl(2);
}

class  Cupboard{
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	Cupboard(){
		System.out.println("Cupboard()");
		bowl4.f1(2);
	}
	void f3(int maker){
		System.out.println("f3("+maker+")");
	}
	static Bowl bowl5 =new Bowl(5);
	
}
public class StaticInitialization {
	public static void main(String[] args) {
		System.out.println("creating new Cupboard() in main");
		new Cupboard();
		System.out.println("creating new Cupboard() in main");
		new Cupboard();
		
	}
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
}
