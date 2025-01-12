class P120834 {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String[] alpa = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        
        while (age > 0) {
            int digit = age % 10;  // 나이의 마지막 자릿수
            answer.insert(0, alpa[digit]);  // 해당 숫자에 대응하는 알파벳을 앞에 추가
            age /= 10;  // 다음 자릿수로 이동
        }
        
        return answer.toString();
    }
}
