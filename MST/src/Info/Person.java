package Info;

import java.util.HashMap;

public class Person {
	private String name;
	private HashMap<String,Integer> interests;
	
	public Person(String name,int sports,int music,int newsShow,int science) {
		this.name = name;
		interests.put("sports", sports);
		interests.put("music", music);
		interests.put("newsShow", newsShow);
		interests.put("science", science);
	}
	
	public String getName() {
		return name;
	}
	
	public int getInterest(String interest) {
		return interests.get(interest);
	}
}
