import java.util.List;

public class Question {
	
	//write your code here
	private Integer id;
	private String category;
	private User questioner;
	private List<Answer> answerList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public User getQuestioner() {
		return questioner;
	}
	public void setQuestioner(User questioner) {
		this.questioner = questioner;
	}
	public List<Answer> getAnswerList() {
		return answerList;
	}
	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	public Question(Integer id, String category, User questioner, List<Answer> answerList) {
		super();
		this.id = id;
		this.category = category;
		this.questioner = questioner;
		this.answerList = answerList;
	}
	public Question() {
		super();
	}
	
}
