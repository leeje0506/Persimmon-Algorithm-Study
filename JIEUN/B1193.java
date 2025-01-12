import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        int diagonal = 1; // 대각선 번호
        int sum = 1; // 대각선 번호까지의 숫자 합

        // X가 포함된 대각선 번호를 찾음
        while (X > sum) {
            diagonal++;
            sum += diagonal;
        }

        int positionInDiagonal = X - (sum - diagonal); // 대각선 내에서의 위치

        int numerator, denominator;
        if (diagonal % 2 == 0) {
            // 짝수 대각선의 경우
            numerator = positionInDiagonal;
            denominator = diagonal - positionInDiagonal + 1;
        } else {
            // 홀수 대각선의 경우
            numerator = diagonal - positionInDiagonal + 1;
            denominator = positionInDiagonal;
        }

        System.out.println(numerator + "/" + denominator);
    }
}
