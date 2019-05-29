import java.util.ArrayList;
import java.util.List;

public class User {
	//Your code goes here...
	private String name;
	private String gender;
	private String email;
	private String country;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public User(String name, String gender, String email, String country) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.country = country;
	}

	public User() {
		super();
	}

	public static List<User> prefill(){ 
		List<User> userList=new ArrayList<>(); 
		userList.add(new User("Harry","Male","harry@gmail.com","India")); 
		userList.add(new User("Danny","Male","danny@gmail.com","England")); 
		userList.add(new User("Joe","Male","joe@yahoo.com","Scotland")); 
		userList.add(new User("Dean","Male","dean@rediff.com","India")); 
		userList.add(new User("James","Male","james@google.com","Canada")); 
		userList.add(new User("Matt","Male","matt@yahoo.com","USA")); 
		userList.add(new User("Rob","Male","rob@hotmail.com","India")); 
		userList.add(new User("Brandon","Male","brandon@gmail.com","Norway")); 
		userList.add(new User("Emilia","Female","emilia@rediff.com","New Zealand")); 
		userList.add(new User("Sophie","Female","sophie@hotmail.com","India")); 
		userList.add(new User("Scarlett","Female","scarlett@gmail.com","Sri Lanka")); 
		return userList; 
	}
}
