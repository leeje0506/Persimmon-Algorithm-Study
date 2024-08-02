/*
작성자 : 이지은
작성일시 : 2024-08-2, 금, 23:20
입력 :
출력 : int
조건 : 그룹 단어의 개수 출력
그룹 단어란, 각 문자가 연속해서 나타나는 경우만.
예, cccaaazzzb 는 c,a,z,b가 연속, aabbccb 는 b가 떨어져있기 때문에 그룹 아님.
문제풀이 :
한 문자가 이전 문자와 같으면 계속 진행 이대로 끝나면 그룹 단어.
이전 문자와 다르고 & 나온 적 있다면 그룹 단어 아님.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class B1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 단어 수 입력
        int result = 0; // 그룹 단어 개수 초기화

        for (int i = 0; i < N; i++) {
            String input = br.readLine(); // 단어 입력
            Set<Character> seenCharacters = new HashSet<>(); // 등장한 적 있는 문자 저장할 셋
            boolean isGroupWord = true; // 그룹 단어 여부 초기화
            char prevChar = '\0'; // 이전 문자 초기화

            // 단어의 각 문자 순회
            for (char c : input.toCharArray()) {
                if (c != prevChar) { // 현재 문자가 이전 문자와 다르면
                    if (seenCharacters.contains(c)) { // 이미 등장한 적 있는 문자면
                        isGroupWord = false; // 그룹 단어 아님
                        break;
                    }
                    seenCharacters.add(c); // 본 문자에 추가
                    prevChar = c; // 현재 문자를 이전 문자로 갱신
                }
            }

            if (isGroupWord) { // 그룹 단어이면
                result++; // 그룹 단어 개수 증가
            }
        }

        // 그룹 단어 개수 출력
        System.out.println(result);
    }
}
