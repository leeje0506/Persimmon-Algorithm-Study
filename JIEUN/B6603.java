
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B6603 {

    static int K;
    static int [] arr;
    static boolean [] visited;
    static int [] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            if( K ==0)
                break;

            arr = new int[K];
            visited = new boolean[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            result = new int[6];
            visited = new boolean[K];
            back(0, 0);

            System.out.println(sb);
            sb.setLength(0); // 출력 후 StringBuilder 초기화

        }
    }//main

    public static void back(int start, int dep){

        //6개만 고를 거임.
        if(dep == 6){
//            //숫자 뽑아서 넣어 그리고 스트링빌더 고
            for(int num: result){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        //안녕하세요 전 백트래킹이에요
        for (int i = start; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[dep] = arr[i];
                //하나 뽑았다~
                back(i, dep + 1);
                visited[i] = false;
            }
        }
    }

}//class
