class Solution {
    // 최대 공약수를 구하는 메서드 (유클리드 호제법 사용)
    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // 최소 공배수를 구하는 메서드
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public int solution(int n) {
        // 6조각의 피자와 n명 사이의 최소 공배수 구하기
        int lcmValue = lcm(6, n);
        
        // 최소 공배수를 6으로 나누면 필요한 피자 판 수가 나옴
        int answer = lcmValue / 6;
        
        return answer;
    }
}
