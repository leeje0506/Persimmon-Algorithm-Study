import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<Integer>[] graph;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N];
        graph = new ArrayList[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            population[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int adj = Integer.parseInt(st.nextToken()) - 1;
                graph[i].add(adj);
            }
        }

        // 부분 집합으로 그룹 나누기
        for (int i = 1; i < (1 << N) - 1; i++) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) groupA.add(j);
                else groupB.add(j);
            }

            // 두 그룹 모두 연결되어 있는지 확인
            if (isConnected(groupA) && isConnected(groupB)) {
                int diff = Math.abs(getPopulation(groupA) - getPopulation(groupB));
                minDiff = Math.min(minDiff, diff);
            }
        }

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    // 해당 그룹이 연결되어 있는지 BFS로 확인
    static boolean isConnected(List<Integer> group) {
        if (group.isEmpty()) return false;
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();
        q.add(group.get(0));
        visited[group.get(0)] = true;

        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }
        return count == group.size();
    }

    // 그룹의 총 인구 계산
    static int getPopulation(List<Integer> group) {
        int sum = 0;
        for (int i : group) sum += population[i];
        return sum;
    }
}
