import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
작성자 : 이지은
작성일시 : 2024-07-9, 화, 19:39

입력 :
테케개수
체스판 한 변의 길이 (I)
나이트가 현재 있는 칸 (n*m)
나이트가 이동하려는 칸  (n*m)

출력 : 각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지

조건 : 나이트는 항상 움직이는 상태다.
나이트가 한번에 이동할 수 있는 칸은 (사방+1칸)+(대각선 양옆)
나이트의 이동 방향 배열
나이트가 이동할 수 있는 8가지 방향
1.수평으로 2칸 이동하고 수직으로 1칸 이동
2.수평으로 1칸 이동하고 수직으로 2칸 이동

문제풀이 : 이동할 수 있는 부분을 탐색한다. 해당 칸에 도달할 때까지.
최단거리를 찾는 탐색법을 사용해야하기 때문에 bfs를 사용해본다.
모든 이동 방향
(-2, 1) : 왼쪽으로 2칸, 위로 1칸 이동
(-1, 2) : 왼쪽으로 1칸, 위로 2칸 이동
(1, 2) : 오른쪽으로 1칸, 위로 2칸 이동
(2, 1) : 오른쪽으로 2칸, 위로 1칸 이동
(2, -1) : 오른쪽으로 2칸, 아래로 1칸 이동
(1, -2) : 오른쪽으로 1칸, 아래로 2칸 이동
(-1, -2): 왼쪽으로 1칸, 아래로 2칸 이동
(-2, -1): 왼쪽으로 2칸, 아래로 1칸 이동
*/

public class B7562 {
    public static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static int t, i, sr, sc, er, ec;
    public static boolean [][] visited;
    public static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine()); //테케 갯수

        for (int tc = 0; tc < t; tc++) {
            i= Integer.parseInt(br.readLine()); //체스판 한 변의 길이

            StringTokenizer st = new StringTokenizer(br.readLine());
            sr = Integer.parseInt(st.nextToken());
            sc = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());

            System.out.println(bfs(i, sr, sc, er, ec));
        }

    }

    public static int bfs(int i, int sr, int sc, int er, int ec) {
        if (sr == er && sc == ec) {
            return 0; // 시작점과 목표점이 같은 경우
        }

        queue = new LinkedList<int[]>();
        visited = new boolean[i][i];
        queue.add(new int[]{sr, sc, 0}); //시작 좌표와 이동 횟수
        visited[sr][sc]=true; //시작 좌표 방문 표시

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int move = cur[2]; //이동횟수

            if(x == er && y == ec){
                return move;
            }

            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if(nx >=0 && ny >=0 && nx < i && ny < i && !visited[nx][ny]){
                    if (nx == er && ny == ec) {
                        return move + 1; // 목표 위치에 도달하면 이동 횟수를 반환
                    }

                    visited[nx][ny] = true;
                    queue.add(new int[] {nx, ny, move + 1});
                }
            }
        }
        return -1; // 이동 불가능한 경우.
        //문제 조건 상 나이트는 항상 이동하므로 사용되지 않는 값임.
    }
}
