import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;  

public class B24444 {
    public static ArrayList<Integer>[] graph;
    public static int[] visited;
    public static int n, m, r, u, v, cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄의 입력을 읽어서 정점의 수, 간선의 수, 시작 정점을 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        visited = new int[n+1];
        cnt = 1;

        // 그래프와 방문 배열 초기화
        for (int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받아서 그래프 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 인접 정점 오름차순 정렬
        for (int i = 1; i < n+1; i++) {
            Collections.sort(graph[i]);
        }

        // 너비 우선 탐색 시작
        bfs(r);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb.toString());


    }

    // 너비 우선 탐색 함수
    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = cnt++; // 시작 정점 방문 순서 기록

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 정점을 꺼낸다

            // 인접 정점 방문
            for (int next : graph[node]) {
                if (visited[next] == 0) { // 방문하지 않은 정점이면
                    visited[next] = cnt++; // 방문 순서 기록
                    queue.add(next); // 큐에 추가
                }
            }
        }
    }
}
