public class FindKim {
	 public static void main(String[] args) {
		FindKimSolution solution = new FindKimSolution();
        String[] seoul = {"Jane", "Kim"};
        System.out.println(solution.solution(seoul));
    }
}

class FindKimSolution {
	String answer = "";
	public String solution(String[] seoul) {
        for(int kimIsHere=0; kimIsHere < seoul.length; kimIsHere++) {
        	if("Kim".equals(seoul[kimIsHere])) {
        		answer = "김서방은 " + kimIsHere + "에 있다.";
        	}
        }
        return answer;
    }
}
	
	

