package chapter19.enumerated;

import java.util.Iterator;

 class Mail {
	enum GeneralDelivery{ YES,NO1,NO2,NO3,YES4}
	enum Readability{ ILLEGIBLE,YES1,YES2,YES3,YES4}
	enum Address{INCORRECT,OK1,OK2,OK3,OK4}
	
	GeneralDelivery generalDelivery;
	Readability readability;
	Address address;
	static long counter = 0;
	long id = counter++;
	public String toString() { return  "Main " + id; }
	public String details(){
		return toString() + 
				", General Delivery : " +generalDelivery +
				", Readability  : " +readability +
				", address : " +address;
	}
	public static Mail randomMail(){
		Mail m = new Mail();
		m.generalDelivery = Enums.random(GeneralDelivery.class);
		m.readability = Enums.random(Readability.class);
		m.address = Enums.random(Address.class);
		return m;
	}
	
	public static Iterable<Mail> generator(final int count){
		return new Iterable<Mail>(){
			int n = count;
			@Override
			public Iterator<Mail> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Mail>(){
					public boolean hasNext() {return n -- > 0; }
					public Mail next(){ return randomMail();}
					public void remove(){
						throw new UnsupportedOperationException();
					}
				};
			}};
	}
}
	public class PostOffice{
		
		enum MailHandler{
			GENERAL_DELEVERY{
				boolean handle(Mail m){
					switch(m.generalDelivery){
					case YES:
						System.out.println("Using general delivery for " + m );
						return true;
						default :return false;
					}
				}
			},
			
			VISUAL_INSPECTION{
				boolean handle(Mail m){
					switch(m.readability){
					case ILLEGIBLE:
					return false;
						default :
							System.out.println("Delivering " + m + "normally");
							return true;
					}
				}
			};
			abstract boolean handle(Mail m);
		}
		static void handle(Mail m){
			for(MailHandler handler : MailHandler.values())
				if(handler.handle(m))
					return;
			System.out.println(m + " is a dead letter");
	}
		
		public static void main(String[] args) {
			for(Mail mail : Mail.generator(10)){
				System.out.println(mail.details());
				handle(mail);
				System.out.println("*******");
			}
		}
	
	}
