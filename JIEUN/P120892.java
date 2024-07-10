class P120892 {
    public String solution(String cipher, int code) {
        String answer = "";
        
        String [] str = cipher.split("");
        
        for(int i=code-1; i<str.length; i+=code){
            
                answer += str[i];
            
            
        }
        return answer;
    }
}
