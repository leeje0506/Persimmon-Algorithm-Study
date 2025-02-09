import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 우선순위 큐 (최소 힙)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 입력값을 최소 힙에 삽입
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int totalCompare = 0;
        
        // 최소 두 개 이상의 묶음이 남아 있을 때까지 진행
        while (pq.size() > 1) {
            int first = pq.poll();  // 가장 작은 묶음
            int second = pq.poll(); // 두 번째로 작은 묶음
            
            int sum = first + second;
            totalCompare += sum; // 비교 횟수 누적
            
            pq.add(sum); // 합친 묶음을 다시 힙에 삽입
        }

        System.out.println(totalCompare);
    }
}
