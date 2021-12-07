private static String solution(int a, int b) {
		String answer = "";
		LocalDate date = LocalDate.of(2016, a, b);
		DayOfWeek str = date.getDayOfWeek();
		answer=(String.valueOf(str)).substring(0,3);
		return answer;
	}