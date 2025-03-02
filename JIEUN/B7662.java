import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); // 연산 개수
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
            Map<Integer, Integer> countMap = new HashMap<>(); // 각 숫자의 개수 추적
            
            for (int i = 0; i < k; i++) {
                String[] command = br.readLine().split(" ");
                char op = command[0].charAt(0);
                int num = Integer.parseInt(command[1]);

                if (op == 'I') { // 삽입 연산
                    minHeap.add(num);
                    maxHeap.add(num);
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                } else { // 삭제 연산 (D 1 또는 D -1)
                    if (countMap.isEmpty()) continue; // 큐가 비어있으면 무시

                    PriorityQueue<Integer> targetHeap = (num == 1) ? maxHeap : minHeap; // D 1이면 최대 힙, D -1이면 최소 힙
                    
                    while (!targetHeap.isEmpty()) {
                        int value = targetHeap.poll();
                        if (countMap.containsKey(value)) { // 실제 존재하는 값인지 확인
                            countMap.put(value, countMap.get(value) - 1);
                            if (countMap.get(value) == 0) countMap.remove(value);
                            break;
                        }
                    }
                }

                // 불필요한 값 정리 (minHeap, maxHeap 간 데이터 불일치 해결)
                while (!minHeap.isEmpty() && !countMap.containsKey(minHeap.peek())) minHeap.poll();
                while (!maxHeap.isEmpty() && !countMap.containsKey(maxHeap.peek())) maxHeap.poll();
            }

            // 최종 결과 출력
            if (countMap.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                int maxValue = maxHeap.peek();
                int minValue = minHeap.peek();
                sb.append(maxValue).append(" ").append(minValue).append("\n");
            }
        }
        
        System.out.print(sb);
    }
}
