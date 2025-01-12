import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12761 {

    static  class Node{
        int pos, cnt;

        Node(int pos, int cnt){
            this.pos = pos;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken()); //스카이콩콩 a
        int b = Integer.parseInt(st.nextToken()); //스카이콩콩 b
        int n = Integer.parseInt(st.nextToken()); //동규 위치
        int m = Integer.parseInt(st.nextToken()); //주미 위치

        //Bfs 탐색
        System.out.println(bfs(a, b, n, m));
    }

    static int bfs(int a, int b, int n, int m) {

        // 초기 값이 같은 경우 바로 종료
        if (n == m) return 0;

        boolean [] visited = new boolean[100001]; //방문 여부 확인
        Queue<Node> q = new LinkedList<>();

        //초기 위치
        q.offer(new Node(n,  0));
        visited[n] = true;

        //Bfs 탐색
        while(!q.isEmpty()){
            Node current = q.poll();
            int pos = current.pos;
            int cnt = current.cnt;

            System.out.println("현재 위치: " + pos + ", 이동 횟수: " + cnt);

            //가능한 다음 위치
            int[]  nextPos = {
                    pos -1,
                    pos +1,
                    pos +a,
                    pos -a,
                    pos +b,
                    pos -b,
                    pos *a,
                    pos *b
            };

            //유효 이동
            for(int next : nextPos){
                if(next >=0 && next <= 100000 && !visited[next]){

                    //종료 조건 : 주미 위치에 도달
                    if(next == m){
                        return cnt+1;
                    }

                    //큐에 추가
                    visited[next] = true;
                    q.offer(new Node(next, cnt+1));
                }
            }
        }

        //도달할 수 없다.
        return -1;
    }
}
