import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, cost;
    
    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node other) {
        return this.cost - other.cost; // 최소 힙 정렬 (오름차순)
    }
}

public class Main {
    static final int INF = 200000000; // 충분히 큰 값(무한대 대체)
    static int N, E;
    static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c)); // 양방향 그래프
        }

        // 반드시 거쳐야 하는 두 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다익스트라 실행
        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        // 가능한 두 경로 중 최소 선택
        int route1 = dist1[v1] + distV1[v2] + distV2[N]; // 1 → v1 → v2 → N
        int route2 = dist1[v2] + distV2[v1] + distV1[N]; // 1 → v2 → v1 → N

        int result = Math.min(route1, route2);
        
        // 경로가 없으면 -1 출력
        System.out.println(result >= INF ? -1 : result);
    }

    // 다익스트라 알고리즘 (최단 거리 계산)
    public static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : graph.get(now.vertex)) {
                int newDist = dist[now.vertex] + next.cost;
                if (newDist < dist[next.vertex]) {
                    dist[next.vertex] = newDist;
                    pq.add(new Node(next.vertex, newDist));
                }
            }
        }
        return dist;
    }
}
