import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
n : 양의 정수
F(n) : n의 각 자리 수 a에 대해서 그 수를 (9-a)로 바꾼 것
가장 큰 자리수의 유효숫자보다 앞에 등장하는 0들은 무시한다.
9의 반전은 0, 91의 반전은 8, 124의 반전은 875, 990의 반전은 9

사랑스러움 : n * F(n)

입력 : N
출력 : 1이상 N이하인 수들의 '사랑스러움' 중 최댓값

0 ~ 9 : 사랑스러움 최댓값은 5에서 나옴 (5*4 = 20)
10 ~ 99 : 사랑스러움 최댓값은 50에서 나옴 (50*49 = 2450)

그렇다면 중간값일 때 사랑스러움 최댓값을 가질 확률이 가장 높다고 판단한다.
=> n이 특정 자릿수 범위라면, 그 자릿수의 중간값에서 사랑스러움 최댓값이 나올 가능성이 높다.
 */

public class B11947 {
    public static long t, n, result, a, answer, middle;
    public static long multiplier = 1L;
    public static long max = 0L;
//    public static boolean Zero = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Long.parseLong(br.readLine());
        for (int i = 0; i < t; i++) {
            n = Long.parseLong(br.readLine());
            answer = Lovely(n);
            System.out.println(answer);
        }
    }


    //n의 반전을 구하는 메서드
    public static long Banjeon(long n) {

        //이건 0을 미리 무시하는 방식이기 때문에 중간에 불필요하게 값을 무시하여 계산을 제대로 하지 않는 문제가 발생함.
//        result = 0L;
//        Zero = false;
//        multiplier = 1L;
//
//        //각 자리 수 a 구하기
//        while (n > 0) {
//            a = n % 10;
//            long reverseNumber = 9 - a;
//
//            //0이면 무시
//            if (reverseNumber != 0) {
//                Zero = true;
//            }
//
//            if (Zero) {
//                result += reverseNumber * multiplier;
//                multiplier *= 10;
//            }
//
//            n = n / 10;
//        }

        //자릿수가 필요한 거라서 반전을 모두 처리한 후에 최종적으로만 0 처리를 해주면 됨.

        result = 0L;
        multiplier = 1L;

        while (n > 0) {
            a = n % 10;
            long reverseNumber = 9 - a;
            result += reverseNumber * multiplier;
            multiplier *= 10;
            n /= 10;
        }

        return result;
    }


    // 사랑스러움 : n * Banjeon(n)의 최댓값을 구하는 메서드.
    public static long Lovely(long n) {
        max = n * Banjeon(n);
        middle = Middle(n);

        // 중간값이 n보다 크다면, n의 자릿수 마지막 값으로 계산하도록 변경
        if (middle > n) {
            middle = n;  // 중간값이 n을 넘지 않도록 처리
        }

        // n과 자릿수 중간값의 사랑스러움을 비교해 더 큰 값 선택
        max = Math.max(max, middle * Banjeon(middle));

        return max;
    }


    //자릿수에 따라 중간값을 구하는 메서드
    public static long Middle(long n) {
        int digit = Long.toString(n).length();  // 자릿수 계산
        return (long) Math.pow(10, digit - 1) * 5;  // 자릿수에 따른 중간값 계산
    }
}
