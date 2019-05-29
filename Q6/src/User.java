import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class User {
	
	//write your code here
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

	public static List<User> prefill() {
		List<User> userList = new ArrayList<>();
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
	
	public static Map<String,String> rankOfUsers(List<User> userList,List<Question> questionList) {
		
		//write your code here
		Map<String,String> tr=new TreeMap<String,String>();
		
		for (User user : userList) {
			boolean flag = false;
			for (Question question : questionList) {
				int answerCount=0;
				if(user.getName().equals(question.getQuestioner().getName())){
					flag=true;
					for (Answer answer : question.getAnswerList()) {
						if(answer.getIsAccepted() || answer.getVotes()>= 500){
							answerCount++;
						}
					}
					//System.out.println(answerCount);
					if(answerCount>7)
						tr.put(user.getName(), "Diamond");
					else if(answerCount>5)
						tr.put(user.getName(), "Gold");
					else if(answerCount>3)
						tr.put(user.getName(), "Silver");
					else 
						tr.put(user.getName(), "Bronze");
					break;
				}
			}
			if(!flag)
				tr.put(user.getName(), "Bronze");
		}
		
		return tr;
	}
}
