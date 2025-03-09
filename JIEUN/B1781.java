import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  // 문제 개수 입력
        
        List<int[]> problems = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cupRamen = Integer.parseInt(st.nextToken());
            problems.add(new int[]{deadline, cupRamen});
        }
        
        // (1) 데드라인 기준 오름차순 정렬
        problems.sort(Comparator.comparingInt(a -> a[0]));

        // (2) 최소 힙(PriorityQueue) 생성 (컵라면 개수 기준)
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] problem : problems) {
            int deadline = problem[0];
            int cupRamen = problem[1];

            pq.offer(cupRamen); // 일단 큐에 추가

            // (3) 만약 현재 문제 수가 데드라인보다 크다면 가장 작은 값 제거
            if (pq.size() > deadline) {
                pq.poll();
            }
        }

        // (4) 큐에 남아있는 모든 컵라면 개수를 합산
        int totalCupRamen = 0;
        while (!pq.isEmpty()) {
            totalCupRamen += pq.poll();
        }

        System.out.println(totalCupRamen);
    }
}
