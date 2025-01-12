import java.io.*;
import java.util.*;

public class BN16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        
        System.out.println(bfs(A, B));
    }

    public static int bfs(long A, long B) {
        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{A, 1});

        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            long value = current[0];
            long steps = current[1];

            // 목표값에 도달하면 연산 횟수 반환
            if (value == B) {
                return (int) steps;
            }

            // 2배 연산
            long nextValue1 = value * 2;
            if (nextValue1 <= B) {
                queue.offer(new long[]{nextValue1, steps + 1});
            }

            // 1 추가 연산
            long nextValue2 = value * 10 + 1;
            if (nextValue2 <= B) {
                queue.offer(new long[]{nextValue2, steps + 1});
            }
        }

        // 목표값을 만들 수 없는 경우
        return -1;
    }
}
