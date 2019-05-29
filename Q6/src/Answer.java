import java.util.Date;

public class Answer {
	
	//write your code here
	private Integer id;
	private Boolean isAccepted;
	private Integer votes;
	private Date lastUpdated;
	private User answerer;
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
	public Answer(Integer id, Boolean isAccepted, Integer votes, Date lastUpdated, User answerer) {
		super();
		this.id = id;
		this.isAccepted = isAccepted;
		this.votes = votes;
		this.lastUpdated = lastUpdated;
		this.answerer = answerer;
	}
	public Answer() {
		super();
	}
	
	
}
