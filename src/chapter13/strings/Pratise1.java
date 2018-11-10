package chapter13.strings;

import java.util.regex.Pattern;

public class Pratise1 {
	private static String s = "Java now has regular experssions";
	public static void testRegex(String[] regexs){
		for(String regex : regexs)
			System.out.println(Pattern.compile(regex).matches(regex, s));
//		s.matches(regex)
	}
	
	public static void main(String[] args) {
		String[] regexs = {"^Java.*", "reg","n.w\\s+h(a|i)s","(J|j)ava.*",
				"s*","s+","s{4},s{1},s{0,9}"};
		testRegex(regexs);
	}
}
