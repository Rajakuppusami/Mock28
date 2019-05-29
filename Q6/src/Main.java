import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		System.out.println("Enter the number of Questions:");
		
		//write your code here
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		List<User> userList = User.prefill();
		List<Question> questionList=new ArrayList<Question>();
		Integer n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			System.out.println("Enter the Question:");
			String questionDetails = br.readLine();
			String questionDet[]=questionDetails.split(",");
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
			List<Answer> answerList = new ArrayList<Answer>();
			System.out.println("Enter the number of Answers:");
			Integer m = Integer.parseInt(br.readLine());
			for (int j = 0; j < m; j++) {
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
				answer.setAnswerer(answerer);
				answerList.add(answer);
			}
			question.setAnswerList(answerList);
			questionList.add(question);
		}
		System.out.format("%-15s%s\n","User","Rank");
		Map<String,String> tr=User.rankOfUsers(userList, questionList);
		for (Map.Entry<String, String> entry : tr.entrySet()) {
			System.out.format("%-15s%s\n",entry.getKey(),entry.getValue());
		}
	}
}
