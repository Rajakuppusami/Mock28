import java.util.Comparator;

public class LastUpdatedComparator implements Comparator<Answer>{
	//Your code goes here...
	@Override
	public int compare(Answer o1, Answer o2) {
		// TODO Auto-generated method stub
		//return (int) (o1.getLastUpdated().getTime()-o2.getLastUpdated().getTime());
		return o1.getLastUpdated().compareTo(o2.getLastUpdated());
	}
	
}
