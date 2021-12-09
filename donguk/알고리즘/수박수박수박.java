public static String solution(int n) {
		
		char su = '수';
		char park = '박';
	    String answer = "";
	    for(int i=1; i <= n; i++) {
	    	if(i%2==0) {
		    	answer += park;
		    }else {
		    	answer += su;
		    }
		    
	    }    
	        
	    return answer;
	}