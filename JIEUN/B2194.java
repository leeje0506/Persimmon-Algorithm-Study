import java.io.*;
import java.util.*;

public class Main {
    static int N, M, A, B, K;
    static boolean[][] obstacles;
    static boolean[][] visited;
    static int startX, startY, endX, endY;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 입력 처리
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        obstacles = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        // 2. 장애물 입력
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            obstacles[x][y] = true;
        }

        // 3. 시작점과 도착점 입력
        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());

        // 4. BFS 탐색
        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            // 도착점 도달 시 종료
            if (x == endX && y == endY) {
                return dist;
            }

            // 상하좌우 이동 시도
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 유효한 이동인지 체크
                if (isValidMove(nx, ny)) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1; // 도달 불가능
    }

    static boolean isValidMove(int x, int y) {
        // 유닛이 맵을 벗어나는 경우
        if (x <= 0 || y <= 0 || x + A - 1 > N || y + B - 1 > M) return false;
        // 이미 방문한 경우
        if (visited[x][y]) return false;

        // A×B 영역이 장애물 없이 이동 가능한지 확인
        for (int i = x; i < x + A; i++) {
            for (int j = y; j < y + B; j++) {
                if (obstacles[i][j]) return false;
            }
        }
        return true;
    }
}
