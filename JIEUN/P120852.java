import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n) {
        Set<Integer> factors = new HashSet<>();
        
        // 2로 나누기
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }
        
        // 3 이상의 홀수로 나누기
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        
        // 남아 있는 n이 소수인 경우
        if (n > 2) {
            factors.add(n);
        }
        
        // Set을 배열로 변환하고 정렬
        return factors.stream().sorted().mapToInt(i -> i).toArray();
    }
}
