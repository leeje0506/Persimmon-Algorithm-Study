import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class B10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); // 테스트케이스 개수 입력받음
        int[] testCases = new int[T];
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine()); // 각 테스트케이스 숫자 입력받음
        }
        
        // 최대 1000까지 커버하는 삼각수를 저장할 배열 만들기
        int[] triangleNumbers = new int[45]; // 45번째 삼각수까지 저장하면 1000 넘어감
        for (int i = 1; i < 45; i++) {
            triangleNumbers[i] = i * (i + 1) / 2; // 삼각수 공식 이용해서 저장함
        }
        
        StringBuilder sb = new StringBuilder();
        for (int k : testCases) {
            boolean found = false; // 합이 되는지 찾기 위한 플래그
            for (int i = 1; i < 45 && !found; i++) {
                for (int j = 1; j < 45 && !found; j++) {
                    for (int l = 1; l < 45 && !found; l++) {
                        if (triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[l] == k) {
                            found = true; // 삼각수 세 개 합이 k랑 같으면 플래그 true
                        }
                    }
                }
            }
            if (found) {
                sb.append("1\n"); // 찾았으면 1 출력
            } else {
                sb.append("0\n"); // 못 찾았으면 0 출력
            }
        }
        
        System.out.print(sb.toString()); // 결과 한꺼번에 출력
    }
}
