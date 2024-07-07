import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R; // 정점의 수 N, 간선의 수 M, 시작 정점 R
    static ArrayList<Integer>[] graph; // 그래프의 인접 리스트
    static int[] visited; // 각 정점의 방문 순서를 저장할 배열
    static int order = 1; // 방문 순서를 기록할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 첫 줄의 입력을 읽어서 정점의 수, 간선의 수, 시작 정점을 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 그래프와 방문 배열 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        visited = new int[N + 1]; // 방문 순서를 저장할 배열 초기화

        // 간선 입력 받아서 그래프 구성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        // 인접 정점 내림차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        // 너비 우선 탐색 시작
        bfs(R);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb.toString());
    }

    // 너비 우선 탐색 함수
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = order++; // 시작 정점 방문 순서 기록

        while (!queue.isEmpty()) {
            int node = queue.poll(); // 큐에서 정점을 꺼낸다

            // 인접 정점 방문
            for (int next : graph[node]) {
                if (visited[next] == 0) { // 방문하지 않은 정점이면
                    visited[next] = order++; // 방문 순서 기록
                    queue.add(next); // 큐에 추가
                }
            }
        }
    }
}
