import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Answer implements Comparable<Answer>{
	//Your code goes here...
	private Integer id;
	private Boolean isAccepted;
	private Integer votes;
	private Date lastUpdated;
	
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

	public Answer(Integer id, Boolean isAccepted, Integer votes, Date lastUpdated) {
		super();
		this.id = id;
		this.isAccepted = isAccepted;
		this.votes = votes;
		this.lastUpdated = lastUpdated;
	}

	public static Answer createAnswer(String line) throws NumberFormatException, ParseException {
		//Your code goes here...
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		String[] details=line.split(",");
		Answer answer = new Answer(Integer.parseInt(details[0]), Boolean.parseBoolean(details[1]), Integer.parseInt(details[2]), sdf.parse(details[3]));
		return answer;
	}

	@Override
	public int compareTo(Answer o) {
		return this.getVotes()-o.getVotes();
	}
}
