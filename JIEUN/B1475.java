import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //0~9 까지 한세트
        // 6과 9는 뒤집어서 사용할 수 있음.

        String roomNumber = br.readLine();
        int[] count = new int[10]; // 0부터 9까지 숫자 세기 위한 배열

        // 각 숫자의 등장 횟수 세기
        for (char c : roomNumber.toCharArray()) {
            int digit = c - '0';
            count[digit]++;
        }

        // 6과 9의 경우 대체 가능하므로 합산하여 반올림
        int sixNineCount = count[6] + count[9];
        count[6] = (sixNineCount + 1) / 2; // 반올림
        count[9] = count[6]; // 9에 대해서도 동일하게 처리

        // 필요한 세트의 개수 계산
        int maxSetCount = 0;
        for (int i = 0; i < 9; i++) { // 0부터 8까지(9는 이미 처리됨)
            maxSetCount = Math.max(maxSetCount, count[i]);
        }

        System.out.println(maxSetCount);
    }
}
