import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] dimensions = br.readLine().split(" ");
        int N = Integer.parseInt(dimensions[0]); // 세로 크기
        int M = Integer.parseInt(dimensions[1]); // 가로 크기
        
        char[][] floor = new char[N][M];
        
        // 바닥 장식 입력받음
        for (int i = 0; i < N; i++) {
            floor[i] = br.readLine().toCharArray();
        }
        
        int count = 0;
        
        // 가로 방향 판자 세기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (floor[i][j] == '-') {
                    count++;
                    while (j < M && floor[i][j] == '-') {
                        j++; // 인접한 '-'를 같은 판자로 처리
                    }
                }
            }
        }
        
        // 세로 방향 판자 세기
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (floor[i][j] == '|') {
                    count++;
                    while (i < N && floor[i][j] == '|') {
                        i++; // 인접한 '|'를 같은 판자로 처리
                    }
                }
            }
        }
        
        System.out.println(count); // 결과 출력
    }
}