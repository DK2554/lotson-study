
public class WatermelonWatermelon {
	public static void main(String[] args) {
		WatermelonSolution solution = new WatermelonSolution();
        System.out.println(solution.solution(3));
    }
}

class WatermelonSolution {
	public String solution(int n) {
        String answer = "";
        String[] arr = new String[n];
        for(int i=0; i<arr.length; i++) {
        	if(i%2 == 0) {
            	arr[i] = "수";
            }else {
            	arr[i] = "박";
            }
        }

		for(String i : arr){
		     answer += i;  
		}
        return answer;
    }
}