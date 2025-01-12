import java.io.*;
import java.util.*;

public class b7576 {
    static int M, N;
    static int[][] box;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        int freshTomatoes = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else if (box[i][j] == 0) {
                    freshTomatoes++;
                }
            }
        }

        if (freshTomatoes == 0) {
            System.out.println(0);
            return;
        }

        int days = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;
            for (int i = 0; i < size; i++) {
                int[] tomato = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = tomato[0] + dx[d];
                    int ny = tomato[1] + dy[d];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < M && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        queue.offer(new int[]{nx, ny});
                        freshTomatoes--;
                    }
                }
            }
            if (freshTomatoes == 0) {
                System.out.println(days);
                return;
            }
        }

        System.out.println(-1);
    }
}
