package chapter9.interfaces.interfaceprocess;

import static chapter1.test1.Print.print;

public class Apply {
	 public static void process(Processor p,Object s){
		 print("Using Processor "+p.name());
			print(p.process(s));
	 }
}
