//머쓱이 구슬 balls, 나누어 줄 구슬 share
//balls 중 share개의 구슬을 고를 수 있는 경우의 수 => 조합

import java.math.BigInteger;

class Solution {
    public int solution(int balls, int share) {
        // 조합 계산 C(n, k) = n! / (k! * (n-k)!)
        BigInteger result = factorial(balls).divide(factorial(share).multiply(factorial(balls - share)));
        
        // BigInteger를 int로 변환하여 answer에 저장
        int answer = result.intValue();
        return answer;
    }

    // 팩토리얼을 계산하는 메서드
    private BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}
