package 연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class exp {
    //사용자 입력, 람다 표현식을 사용한 연산 과정, 연산 결과가 포함된 스크린샷
    //1. 사용자로부터 두 개의 숫자와 연산자(+, -, *, /)를 입력받습니다.
    // 2. 입력받은 연산자에 따라 두 숫자의 연산을 수행합니다.
    // 3. 연산 결과를 출력합니다.
    // 4. 연산 로직은 람다 표현식을 사용하여 구현합니다.
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 1. 사용자로부터 "숫자 연산자 숫자" 형식의 문자열 입력 받기
        System.out.print("계산할 식을 입력하세요 (예: 10 + 5): ");
        String input = reader.readLine();

        // 2. 입력받은 문자열을 공백을 기준으로 분리하여 숫자와 연산자 추출
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            System.out.println("입력 형식이 잘못되었습니다. 예: 10 + 5");
            return;
        }

        double num1;
        double num2;
        String operator;
        try {
            num1 = Double.parseDouble(parts[0]);
            operator = parts[1];
            num2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("유효한 숫자를 입력하세요.");
            return;
        }

        // 3. 람다 표현식을 사용한 연산 로직 정의
        Map<String, BiFunction<Double, Double, Double>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a + b);
        operations.put("-", (a, b) -> a - b);
        operations.put("*", (a, b) -> a * b);
        operations.put("/", (a, b) -> b != 0 ? a / b : null); // 나누기 0 방지

        // 4. 입력받은 연산자에 따라 두 숫자의 연산 수행
        BiFunction<Double, Double, Double> operation = operations.get(operator);
        if (operation != null) {
            Double result = operation.apply(num1, num2);
            // 5. 연산 결과 출력
            if (result != null) {
                System.out.println("연산 결과: " + result);
            } else {
                System.out.println("오류: 0으로 나눌 수 없습니다.");
            }
        } else {
            System.out.println("유효하지 않은 연산자입니다.");
        }
    }
}