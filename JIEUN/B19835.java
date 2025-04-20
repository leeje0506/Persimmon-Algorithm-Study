import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 도시 수
        int m = Integer.parseInt(st.nextToken()); // 도로 수
        int k = Integer.parseInt(st.nextToken()); // 면접장 수

        List<Edge>[] graph = new ArrayList[n + 1]; // 1-indexed
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();

        // 단방향 도로 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()); // 시작 도시
            int v = Integer.parseInt(st.nextToken()); // 도착 도시
            int c = Integer.parseInt(st.nextToken()); // 거리
            graph[v].add(new Edge(u, c)); // 역방향 저장 (면접장에서 도시로)
        }

        // 면접장 정보
        st = new StringTokenizer(br.readLine());
        int[] interview = new int[k];
        for (int i = 0; i < k; i++) {
            interview[i] = Integer.parseInt(st.nextToken());
        }

        // 최단 거리 배열 (초기값 무한대)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 다익스트라 (시작점을 여러 개로)
        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        for (int city : interview) {
            dist[city] = 0;
            pq.add(new Edge(city, 0));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.weight > dist[cur.to]) continue;

            for (Edge next : graph[cur.to]) {
                int cost = dist[cur.to] + next.weight;
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    pq.add(new Edge(next.to, cost));
                }
            }
        }

        // 결과: 가장 멀리 있는 도시 찾기
        int maxDist = -1;
        int city = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                city = i;
            } else if (dist[i] == maxDist && i < city) {
                city = i;
            }
        }

        System.out.println(city);
        System.out.println(maxDist);
    }
}
