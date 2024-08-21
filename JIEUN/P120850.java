import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> solution(String my_string) {
        List<Integer> numbers = new ArrayList<>();  // 숫자들을 저장할 리스트
        
        // 문자열을 순회하면서 숫자를 추출
        for (int i = 0; i < my_string.length(); i++) {
            char ch = my_string.charAt(i);
            if (Character.isDigit(ch)) {  // 숫자인지 확인
                numbers.add(Character.getNumericValue(ch));  // 숫자로 변환하여 리스트에 추가
            }
        }
        
        // 리스트를 오름차순으로 정렬
        Collections.sort(numbers);
        
        return numbers;  // 정렬된 숫자 리스트 반환
    }
}
