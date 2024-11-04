import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

조건 :
1 : 익은 토마토
0 : 익지 않은 토마토
-1 : 토마토 없음

익은 토마토는 익지 않은 토마토에 영향을 준다.
토마토가 스스로 익는 경우는 없다.

입력 :
m n (상자의 크기)
상자에 담긴 토마토 정보 (n개의 줄, 줄마다 m개)

출력 :
토마토가 모두 익을 때까지의 최소 날짜
(이미 모두 익어있다 : 1, 모두 익지 못하는 상태 : -1)
 */

public class B7576_new {
    static int[][] tomatoBox;
    static int n, m, answer;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomatoBox = new int[n][m]; //세로가 n, 가로가 m

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
                if(tomatoBox[i][j] == 1) {
                    queue.add(new int[]{i, j}); //익은 토마토 위치 저장
                }
            }
        }

        answer = bfs();
        System.out.println(answer);
    }

    public static int bfs () {
        int days = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                //인접 4방향 탐색
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if(nx>=0 && ny>=0 && nx<n && ny<m && tomatoBox[nx][ny]==0) {
                        tomatoBox[nx][ny] = 1; //익게 만들기
                        queue.add(new int[]{nx, ny}); //확산
                    }
                }
            }

            //하루가 지나면 일수 증가
            if(!queue.isEmpty()) {
                days++;
            }
        }

        //토마토가 다 익었는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(tomatoBox[i][j]==0) { //익지 않은 토마토가 남은 경우
                    return -1;
                }
            }
        }
        //모든 토마토가 익었다.
        return days;
    }
}
