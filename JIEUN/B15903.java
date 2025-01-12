import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B15903 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 카드 개수
        int m = Integer.parseInt(st.nextToken()); // 합체 횟수

        if (n < 2) {
            throw new IllegalArgumentException("카드의 개수는 2 이상이어야 합니다.");
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken())); // 카드 값을 우선순위 큐에 삽입
        }

        //합체 과정
        for (int i = 0; i < m; i++) {
            if (pq.size() < 2) {
                throw new IllegalStateException("큐에 값이 충분하지 않습니다.");
            }

            long first = pq.poll();
            long second = pq.poll();

            long sum = first + second;
            pq.add(sum);
            pq.add(sum);
        }

        //최종 합 계산
        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll(); // 큐에 남은 모든 값을 더함
        }

        System.out.println(result);
    }
}
