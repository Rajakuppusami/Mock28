import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of questions:");
		//Your code goes here...
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		List<User> userList = User.prefill();
		List<Question> questionList = new ArrayList<Question>();
		Integer n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			System.out.println("Enter question "+(i+1)+" detail:");
			String questionDetails = br.readLine();
			String[] questionDet=questionDetails.split(",");
			Question question = new Question();
			question.setId(Integer.parseInt(questionDet[0]));
			question.setCategory(questionDet[1]);
			User user = null;
			for (User userValue : userList) {
				if(userValue.getName().equalsIgnoreCase(questionDet[2])){
					user=userValue;
					break;
				}
			}
			if(user==null){
				user=new User(questionDet[2], null, null, null);
			}
			question.setQuestioner(user);
			System.out.println("Enter the number of answers for the above question:");
			Integer m = Integer.parseInt(br.readLine());
			List<Answer> answerList = new ArrayList<Answer>();
			for (int j = 0; j < m; j++) {
				System.out.println("Enter answer "+(j+1)+" detail:");
				String answerDetails = br.readLine();
				String[] answerDet = answerDetails.split(",");
				Answer answer = new Answer();
				answer.setId(Integer.parseInt(answerDet[0]));
				answer.setIsAccepted(Boolean.parseBoolean(answerDet[1]));
				answer.setVotes(Integer.parseInt(answerDet[2]));
				answer.setLastUpdated(sdf.parse(answerDet[3]));
				User answerer = null;
				for (User userValue : userList) {
					if(userValue.getName().equalsIgnoreCase(answerDet[4])){
						answerer=userValue;
					}
				}
				if(answerer==null){
					answerer=new User(answerDet[4], null, null, null);
				}
				answer.setQuestion(question);
				answerList.add(answer);
			}
			question.setAnswerList(answerList);
			questionList.add(question);
		}
		System.out.println("Enter a search type:\n1.By Category\n2.By Accepted Answer");
		//Your code goes here...
		QuestionBO questionBO=new QuestionBO();
		Integer choice = Integer.parseInt(br.readLine());
		if(choice==1){
			System.out.println("Enter the Category:");
			String category=br.readLine();
			List<Question> li=questionBO.findQuestion(questionList, category);
			if(li.isEmpty()){
				System.out.println("No such question is present");
			}else{
				System.out.format("%-5s %-15s %s\n","Id","Category","Questioner");
				for (Question question : li) {
					System.out.format("%-5s %-15s %s\n",question.getId(),question.getCategory(),question.getQuestioner().getName());
				}
			}
		}else if(choice==2){
			System.out.println("Enter the Status");
			Boolean status =Boolean.parseBoolean(br.readLine());
			List<Question> li=questionBO.findQuestion(questionList, status);
			if(li.isEmpty()){
				System.out.println("No such question is present");
			}else{
				System.out.format("%-5s %-15s %s\n","Id","Category","Questioner");
				for (Question question : li) {
					System.out.format("%-5s %-15s %s\n",question.getId(),question.getCategory(),question.getQuestioner().getName());
				}
			}
		}else{
			System.out.println("Invalid choice");
		}
	}
}
