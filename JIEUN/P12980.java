class Solution {
    public int solution(int n) {
        int batteryUsage = 0;

        while (n > 0) {
            // 홀수라면 점프 필요
            if (n % 2 == 1) {
                batteryUsage++; // 점프 소모량 추가
                n--; // 점프한 후 1칸 뒤로
            } else {
                // 짝수라면 순간이동 가능
                n /= 2;
            }
        }

        return batteryUsage;
    }
}
