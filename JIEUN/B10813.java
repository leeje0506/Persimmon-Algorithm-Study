import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class B10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫째 줄 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 초기 바구니 설정: 각 바구니에는 같은 번호의 공이 들어있음
        int[] baskets = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            baskets[i] = i;
        }

        // 공 교환 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int basket1 = Integer.parseInt(st.nextToken());
            int basket2 = Integer.parseInt(st.nextToken());

            // 공 교환
            int temp = baskets[basket1];
            baskets[basket1] = baskets[basket2];
            baskets[basket2] = temp;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(baskets[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}