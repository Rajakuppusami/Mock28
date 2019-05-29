import java.util.Date;

public class Answer {
	//Your code goes here...
	private Integer id;
	private Boolean isAccepted;
	private Integer votes;
	private Date lastUpdated;
	private User answerer;
	private Question question;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Boolean getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Integer getVotes() {
		return votes;
	}
	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
	public User getAnswerer() {
		return answerer;
	}
	public void setAnswerer(User answerer) {
		this.answerer = answerer;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public Answer() {
		super();
	}
	public Answer(Integer id, Boolean isAccepted, Integer votes, Date lastUpdated, User answerer, Question question) {
		super();
		this.id = id;
		this.isAccepted = isAccepted;
		this.votes = votes;
		this.lastUpdated = lastUpdated;
		this.answerer = answerer;
		this.question = question;
	}
	
}
