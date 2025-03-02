import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 지도 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // Step 1: 섬에 번호를 부여하기 (BFS)
        visited = new boolean[N][N];
        int islandId = 2; // 섬 번호 (1이 아닌 2부터 시작)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    markIsland(i, j, islandId++);
                }
            }
        }

        // Step 2: 각 섬에서 가장자리 찾기 및 BFS로 다리 건설
        int shortestBridge = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) { // 섬의 번호가 부여된 곳이면
                    shortestBridge = Math.min(shortestBridge, findShortestBridge(i, j, map[i][j]));
                }
            }
        }

        // 최단 다리 길이 출력
        System.out.println(shortestBridge);
    }

    // BFS로 섬을 번호로 표시하는 함수
    static void markIsland(int x, int y, int islandId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = islandId;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : directions) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = islandId;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    // BFS를 이용한 최단 다리 찾기
    static int findShortestBridge(int x, int y, int islandId) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        // 초기 가장자리에서 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == islandId) {
                    queue.offer(new int[]{i, j, 0}); // (x좌표, y좌표, 거리)
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1], dist = cur[2];

            for (int[] dir : directions) {
                int nx = cx + dir[0];
                int ny = cy + dir[1];

                if (isValid(nx, ny) && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) { // 바다인 경우, 다리 연장
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, dist + 1});
                    } else if (map[nx][ny] != islandId) { // 다른 섬에 도착한 경우
                        return dist; // 현재까지의 거리 반환
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    // 좌표가 유효한지 확인하는 함수
    static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
