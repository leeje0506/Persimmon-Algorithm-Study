class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String[] array = my_string.split("");
        
        reverse(array);
        
        // 배열을 문자열로 변환 (구분자 없이 이어붙임)
        answer = String.join("", array);
        
        return answer;
    }
    
    public static void reverse(String[] array){
        int start = 0;
        int end = array.length -1;
        
        while(start<end){
            String tmp = array[start];
            array[start] = array[end];
            array[end] = tmp;
            
            start++;
            end--;
        }
    }
}
