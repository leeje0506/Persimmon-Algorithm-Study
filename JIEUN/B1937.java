import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map, dp;
    static int[] dx = {-1, 1, 0, 0}; // 상하좌우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        dp = new int[n][n];

        // 대나무 숲 정보 입력
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 모든 좌표에서 최대 이동 칸 수 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, dfs(i, j));
            }
        }

        System.out.println(answer);
    }

    // DFS + 메모이제이션
    static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1; // 최소 1칸은 방문 가능

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 체크 + 더 많은 대나무만 이동 가능
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] > map[x][y]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
            }
        }

        return dp[x][y];
    }
}
