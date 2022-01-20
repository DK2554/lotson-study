
import java.util.Arrays;

public class Budget {
	
	 public static void main(String[] args) {
		 BudgetSolution solution = new BudgetSolution();
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(solution.solution(d, budget));
    }
}



class BudgetSolution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for(int i : d) {
        	budget = budget - i;
        	
        	if(budget > 0 || budget == 0) {
        		answer++;
        	}else {
        		break;
        	}
        }
        return answer;
    }
}
	