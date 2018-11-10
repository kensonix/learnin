package chapter5.initialization;

 class Book{
	 private Boolean isChecked = false;
	public Book(Boolean isChecked){
		this.isChecked = isChecked;
	}
	public void checkedin(){
		isChecked = false;
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		if(isChecked){
			System.out.println("Error:this book is not checked in! ");
			super.finalize();
	}
	}
}
public class TerminationCondition {
	public static void main(String[] args) {
		Book  book = new Book(true);
		book.checkedin();
		new Book(true);
		System.gc();
	}
}
