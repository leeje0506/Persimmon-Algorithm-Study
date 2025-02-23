import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph; // 인접 리스트
    static boolean[] visited; // 방문 배열
    static boolean found = false; // 길이가 5인 경로가 있는지 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수 (노드 개수)
        M = Integer.parseInt(st.nextToken()); // 친구 관계 수 (간선 개수)

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        // 친구 관계 입력 (양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        visited = new boolean[N];

        // 모든 노드를 시작점으로 DFS 탐색
        for (int i = 0; i < N; i++) {
            dfs(i, 0);
            if (found) break; // 경로를 찾으면 즉시 종료
        }

        System.out.println(found ? 1 : 0);
    }

    public static void dfs(int node, int depth) {
        if (depth == 4) { // 길이가 5인 경로 발견!
            found = true;
            return;
        }

        visited[node] = true; // 현재 노드 방문

        for (int next : graph.get(node)) {
            if (!visited[next]) { // 방문하지 않은 노드만 탐색
                dfs(next, depth + 1);
                if (found) return; // 경로를 찾았으면 즉시 종료
            }
        }

        visited[node] = false; // 백트래킹 (다른 경로 탐색을 위해 방문 해제)
    }
}
