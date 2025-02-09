import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int cnt = 0;

    static class Robot {
        int x, y, dir;

        Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Robot(r, c, d));

        System.out.println(cnt);
    }

    static void bfs(Robot robot) {
        Queue<Robot> queue = new LinkedList<>();
        queue.offer(robot);

        while(!queue.isEmpty()) {
            Robot curRobot = queue.poll();
            int x = curRobot.x;
            int y = curRobot.y;
            int dir = curRobot.dir;

            if(!visited[x][y] && map[x][y] == 0) {
                visited[x][y] = true;
                cnt++;
            }

            boolean flag = false;
            for(int i=0; i<4; i++) {
                dir = (dir + 3) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if(nx>=0 && ny>=0 && nx<N && ny<M && !visited[nx][ny] && map[nx][ny] == 0) {
                    queue.offer(new Robot(nx, ny, dir));
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                int nx = x - dx[dir];
                int ny = y - dy[dir];
                if(nx>=0 && ny>=0 && nx<N && ny<M && map[nx][ny] != 1) {
                    queue.offer(new Robot(nx, ny, dir));
                }
            }
        }
    }
}
