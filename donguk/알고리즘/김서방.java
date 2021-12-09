private static String solution2(String[] seoul) {
        StringBuilder txt = new StringBuilder("김서방은 ");
        int index = Arrays.asList(seoul).indexOf("Kim");
        txt.append(index);
        txt.append("에 있다");
        return txt.toString();
}