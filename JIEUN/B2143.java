import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 목표 값 입력
        int T = Integer.parseInt(br.readLine());

        // 배열 A 입력
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 입력
        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 부분 배열 합 구하기 (A)
        List<Integer> sumA = getSubarraySums(A, n);

        // 2. 부분 배열 합 구하기 (B) + 해시맵 저장
        Map<Integer, Integer> sumBMap = new HashMap<>();
        List<Integer> sumB = getSubarraySums(B, m);
        for (int sum : sumB) {
            sumBMap.put(sum, sumBMap.getOrDefault(sum, 0) + 1);
        }

        // 3. A의 부분 배열 합을 돌면서 (T - sumA)가 sumBMap에 있는지 확인
        long count = 0;
        for (int sum : sumA) {
            int target = T - sum;
            if (sumBMap.containsKey(target)) {
                count += sumBMap.get(target);
            }
        }

        // 결과 출력
        System.out.println(count);
    }

    // 부분 배열의 모든 합을 구하는 메서드
    private static List<Integer> getSubarraySums(int[] arr, int length) {
        List<Integer> sums = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = i; j < length; j++) {
                sum += arr[j];
                sums.add(sum);
            }
        }
        return sums;
    }
}
