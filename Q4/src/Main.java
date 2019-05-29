import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String args[]) throws NumberFormatException, IOException, ParseException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of answers:");
		//Your code goes here...
		List<Answer> answerList = new ArrayList<Answer>();
		Integer n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			answerList.add(Answer.createAnswer(line));
		}
		System.out.println("Enter a type to sort:\n1.Sort by Votes\n2.Sort by Last Updated Date");
		//Your code goes here...
		Integer choice = Integer.parseInt(br.readLine());
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		if(choice==1){
			Collections.sort(answerList);
			System.out.format("%-5s %-10s %-8s %s\n", "Id","Accected","Votes","Last Updated");
			for (Answer answer : answerList) {
				System.out.format("%-5s %-10s %-8s %s\n", answer.getId(),answer.getIsAccepted(),answer.getVotes(),sdf.format(answer.getLastUpdated()));
			}
		}else if(choice==2){
			Collections.sort(answerList,new LastUpdatedComparator());
			System.out.format("%-5s %-10s %-8s %s\n", "Id","Accected","Votes","Last Updated");
			for (Answer answer : answerList) {
				System.out.format("%-5s %-10s %-8s %s\n", answer.getId(),answer.getIsAccepted(),answer.getVotes(),sdf.format(answer.getLastUpdated()));
			}
		}
	}
}
