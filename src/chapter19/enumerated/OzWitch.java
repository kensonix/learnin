package chapter19.enumerated;

public enum OzWitch{
	WEST("west"),
	EAST("east"),
	SOUTH("south"),
	NORTH("north");
	private String description;
	private OzWitch(String description){
		this.description = description;
	}
	public String  getDescription(){
		return description;
	}
	public static void main(String[] args) {
		for(OzWitch witch : OzWitch.values()){
			System.out.println(witch + ": " + witch.values());
		}
		String s1 = "hello";
		System.out.println(s1.substring(1).toUpperCase());
		System.out.println(OzWitch.values());
	}
}
