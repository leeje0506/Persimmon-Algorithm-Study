import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
조건:
불은 각 지점에서 네 방향으로 확산.
지훈이와 불은 매 분마다 한칸씩 수평 또는 수직으로만 이동. (대각선 불가)

입력:
r c (행, 열)
미로행

#: 벽
.: 지나갈 수 있는 공간
J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
F: 불이 난 공간
J는 입력에서 하나만 주어진다.

출력:
가장 빠른 탈출시간
(불보다 빨리 탈출할 수 없는 경우 : IMPOSSIBLE)
 */

class Point {
    int x, y, time;
    public Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class B4179 {
    static int r, c;
    static char[][] miro;
    static Queue<Point> fireQueue = new LinkedList<>();
    static Queue<Point> jihunQueue = new LinkedList<>();
    static int[][] fireTime;
    static int[][] jihunTime;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        miro = new char[r][c];
        fireTime = new int[r][c];
        jihunTime = new int[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                miro[i][j] = line.charAt(j);
                fireTime[i][j] = -1;
                jihunTime[i][j] = -1;
                if (miro[i][j] == 'J') {
                    jihunQueue.add(new Point(i, j, 0));
                    jihunTime[i][j] = 0;
                }
                if (miro[i][j] == 'F') {
                    fireQueue.add(new Point(i, j, 0));
                    fireTime[i][j] = 0;
                }
            }
        }

        bfsFire();
        int result = bfsJihun();

        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    // 불의 확산 BFS
    public static void bfsFire() {
        while (!fireQueue.isEmpty()) {
            Point p = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < r && ny < c && miro[nx][ny] != '#' && fireTime[nx][ny] == -1) {
                    fireTime[nx][ny] = p.time + 1;
                    fireQueue.add(new Point(nx, ny, p.time + 1));
                }
            }
        }
    }

    // 지훈이의 이동 BFS
    public static int bfsJihun() {
        while (!jihunQueue.isEmpty()) {
            Point p = jihunQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                // 탈출 조건
                if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
                    return p.time + 1; // 가장자리에 도달한 경우
                }

                // 지훈이가 이동할 수 있는지 확인 (불의 시간과 비교)
                if (miro[nx][ny] != '#' && jihunTime[nx][ny] == -1 && (fireTime[nx][ny] == -1 || fireTime[nx][ny] > p.time + 1)) {
                    jihunTime[nx][ny] = p.time + 1;
                    jihunQueue.add(new Point(nx, ny, p.time + 1));
                }
            }
        }
        return -1; // 탈출 실패
    }
}