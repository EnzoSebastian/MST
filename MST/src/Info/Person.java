package Info;

import java.util.HashMap;

import Validations.Validations;

public class Person {
	private String name;
	private HashMap<String,Integer> interests;
	
	public Person(String name,int sports,int music,int newsShow,int science) {
		validation(name,sports,music,newsShow,science);
		interests = new HashMap<>();
		this.name = name;
		interests.put("sports", sports);
		interests.put("music", music);
		interests.put("newsShow", newsShow);
		interests.put("science", science);
	}
	
	private void validation(String name,int sports,int music,int newsShow,int science) {
		Validations.isNull(name);
		Validations.emptyString(name);
		Validations.isLower(sports);
		Validations.isLower(music);
		Validations.isLower(newsShow);
		Validations.isLower(science);
		Validations.isHigher(sports);
		Validations.isHigher(music);
		Validations.isHigher(newsShow);
		Validations.isHigher(science);
	}
	
	public String getName() {
		return name;
	}
	
	public int getInterest(String interest) {
		return interests.get(interest);
	}
}
