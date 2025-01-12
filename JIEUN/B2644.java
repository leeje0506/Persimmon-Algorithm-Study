import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Queue;

/*
조건 :
부모 자식 사이 1촌

입력 :
n  (전체 사람의 수)
a b (촌수를 계산해야하는 두사람)
m (부모 쟈식들 간의 관계 개수)
x y (부모자식 관계 m개, x:부모 y:자식)

출력 :
a b 의 촌수.
(친척 관계가 아니라면 -1)
 */

public class B2644 {
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 사람 수
        int n = Integer.parseInt(br.readLine());

        // 촌수를 계산할 두 사람의 번호
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 부모-자식 관계의 개수
        int m = Integer.parseInt(br.readLine());

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 부모-자식 관계를 입력받아 그래프 구성
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);  // 양방향 그래프
        }

        // 방문 배열 초기화
        visited = new boolean[n + 1];

        // BFS로 촌수 계산 후 결과 출력
        int result = bfs(start, end);
        System.out.println(result);
    }

    public static int bfs(int start, int end) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, 0});  // 시작 노드와 촌수 0을 큐에 삽입
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int person = current[0];
            int degree = current[1];

            // 목표 노드에 도달하면 촌수를 반환
            if (person == end) {
                return degree;
            }

            // 방문하지 않은 이웃 노드를 탐색
            for (int neighbor : graph.get(person)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[] {neighbor, degree + 1});  // 촌수 1 증가
                }
            }
        }

        // 도달할 수 없으면 -1 반환
        return -1;
    }
}
