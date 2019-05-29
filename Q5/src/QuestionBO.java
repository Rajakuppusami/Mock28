import java.util.ArrayList;
import java.util.List;

public class QuestionBO {
	public List<Question> findQuestion(List<Question> qlist,String category){
		//Your code goes here...
		List<Question> li=new ArrayList<Question>();
		for (Question question : qlist) {
			if(question.getCategory().equals(category)){
				li.add(question);
			}
		}
		return li;
	}
	
	public List<Question> findQuestion(List<Question> qlist,Boolean status){
		//Your code goes here...
		List<Question> li=new ArrayList<Question>();
		for (Question question : qlist) {
			int min = 0;
			for (Answer answer : question.getAnswerList()) {
				if(answer.getIsAccepted()){
					min++;
					break;
				}
			}
			if(status){
				if(min>0){
					li.add(question);
				}
			}else{
				if(min==0){
					li.add(question);
				}
			}
		}
		return li;
	}
}
