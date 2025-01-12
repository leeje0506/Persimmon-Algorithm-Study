import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


/*
제곱의 재귀.

입력 : 높이 H
출력 : H 높이의 2타워 값을 3으로 나눈 나머지를 출력.

문제점 : long으로 처리하기에도 값이 커서 오류가 남.
해결법 : BigInteger, 모듈러 사용해서 풀어야 함.
문제 이해를 잘못 했음.. 4층 : 3층 * 3층 이라고 생각했었음.
근데 그냥 제곱수를 계속 곱하는 거였다. 4층 : 2의 (((2^2)^2)^2) 임.

이렇게 되면 2일 때 빼고 나머지는 전부 나머지가 1일 수 밖에 없음.

 */
public class B10407 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger h = new BigInteger(br.readLine());

        // H가 1이면 2 출력, 그 외에는 1 출력
        if (h.equals(BigInteger.ONE)) {
            System.out.println(2);
        } else {
            System.out.println(1);
        }
    }
}
