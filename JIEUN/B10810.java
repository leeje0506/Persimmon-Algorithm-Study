import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 바구니의 개수
        int M = Integer.parseInt(st.nextToken()); // 공을 넣는 횟수
        int[] baskets = new int[N + 1]; // 바구니 상태 배열, 1번 인덱스부터 사용

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken()); // 시작 바구니
            int j = Integer.parseInt(st.nextToken()); // 끝 바구니
            int k = Integer.parseInt(st.nextToken()); // 넣을 공의 번호
            
            for (int b = i; b <= j; b++) {
                baskets[b] = k; // i번부터 j번 바구니까지 k번 공을 넣음
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int b = 1; b <= N; b++) {
            sb.append(baskets[b]).append(' ');
        }
        System.out.println(sb.toString().trim()); // 결과 출력
    }
}