/*
작성자 : 이지은
작성일시 : 2024-08-3, 토, 22:11
입력 : 과목명, 학점, 등급 (20줄 => 과목의 수 고정)
출력 :
조건 : 전공평점 = (학점 * 과목평점)의 합 / 학점의 총합
p인 과목은 계산 제외
문제풀이 : 해쉬맵으로 등급별 평점을 묶자.
HashMap<String, Double> 등급 키, 평점 값.
각 줄을 공백 기준으로 분리.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B25206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 등급별 평점을 저장하는 해시맵 생성
        Map<String, Double> gradeToPoint = new HashMap<>();
        gradeToPoint.put("A+", 4.5);
        gradeToPoint.put("A0", 4.0);
        gradeToPoint.put("B+", 3.5);
        gradeToPoint.put("B0", 3.0);
        gradeToPoint.put("C+", 2.5);
        gradeToPoint.put("C0", 2.0);
        gradeToPoint.put("D+", 1.5);
        gradeToPoint.put("D0", 1.0);
        gradeToPoint.put("F", 0.0);

        // 과목의 수는 20개로 고정
        int n = 20;
        double sum = 0; // 총 평점 * 학점의 합을 저장할 변수
        double total = 0; // 총 학점을 저장할 변수

        for (int i = 0; i < n; i++) {
            String input = br.readLine(); // 입력받은 한 줄을 저장
            String[] parts = input.split(" "); // 공백을 기준으로 문자열 분리
            String grade = parts[2]; // 등급 추출
            double point = Double.parseDouble(parts[1]); // 학점 추출

            if (grade.equals("P")) { // 등급이 P인 경우
                continue; // 계산에서 제외하고 다음 과목으로 넘어감
            }

            double gradePoint = gradeToPoint.get(grade); // 등급에 해당하는 평점 가져옴
            sum += point * gradePoint; // 학점 * 평점을 합산
            total += point; // 학점을 합산
        }

        double result = sum / total; // 전공평점 계산
        System.out.printf("%.6f\n", result); // 소수점 네 자리까지 출력
    }
}
