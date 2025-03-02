import java.io.*;
import java.util.*;

public class Main {
    static final int ROWS = 12, COLS = 6;
    static char[][] field = new char[ROWS][COLS];
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 필드 입력
        for (int i = 0; i < ROWS; i++) {
            field[i] = br.readLine().toCharArray();
        }
        
        int chainCount = 0; // 연쇄 횟수
        
        while (true) {
            visited = new boolean[ROWS][COLS];
            boolean popped = false;
            
            // 1. 같은 색 뿌요 4개 이상 찾고 터뜨리기
            for (int i = 0; i < ROWS; i++) {
                for (int j = 0; j < COLS; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j)) {
                            popped = true;
                        }
                    }
                }
            }
            
            if (!popped) break; // 더 이상 터질 뿌요가 없으면 종료
            
            chainCount++; // 연쇄 횟수 증가
            applyGravity(); // 중력 적용
        }
        
        System.out.println(chainCount);
    }

    // BFS로 같은 색 뿌요 찾기 (4개 이상이면 제거)
    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> toPop = new ArrayList<>();
        char color = field[x][y];
        
        queue.offer(new int[]{x, y});
        toPop.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0], cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || ny < 0 || nx >= ROWS || ny >= COLS) continue;
                if (!visited[nx][ny] && field[nx][ny] == color) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    toPop.add(new int[]{nx, ny});
                }
            }
        }

        if (toPop.size() >= 4) { // 4개 이상이면 터뜨리기
            for (int[] pos : toPop) {
                field[pos[0]][pos[1]] = '.';
            }
            return true;
        }
        return false;
    }

    // 중력 적용
    static void applyGravity() {
        for (int j = 0; j < COLS; j++) {
            for (int i = ROWS - 1; i >= 0; i--) { // 아래에서 위로 탐색
                if (field[i][j] == '.') { // 빈칸이면 위에서 내려오도록 처리
                    int k = i - 1;
                    while (k >= 0 && field[k][j] == '.') {
                        k--; // 가장 가까운 뿌요 찾기
                    }
                    if (k >= 0) {
                        field[i][j] = field[k][j];
                        field[k][j] = '.';
                    }
                }
            }
        }
    }
}
