package GamnamuStudy;

import java.io.*;
import java.util.*;

public class BJ_1781_컵라면 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> problems = new PriorityQueue<>((a, b) -> {
            int result = a[0] - b[0];
            return result == 0 ? b[1] - a[1] : result;
        });

        while (N-- > 0) {
            String[] input = br.readLine().split(" ");
            int deadLine = Integer.parseInt(input[0]);
            int numOfRamen = Integer.parseInt(input[1]);

            problems.offer(new int[]{deadLine, numOfRamen});
        }

        PriorityQueue<Integer> select = new PriorityQueue<>();

        while (!problems.isEmpty()) {
            int[] problem = problems.poll();
            int deadLine = problem[0];
            int numOfRamen = problem[1];

            if (select.size() < deadLine) {
                select.offer(numOfRamen);
            } else {
                if (select.peek() < numOfRamen) {
                    select.poll();
                    select.offer(numOfRamen);
                }
            }
        }

        long result = 0L;
        for (Integer numOfRamen : select) {
            result += numOfRamen;
        }
        System.out.println(result);
    }
}
