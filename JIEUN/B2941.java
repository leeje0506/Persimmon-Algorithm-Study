/*
작성자 : 이지은
작성일시 : 2024-07-31, 수, 22:57
입력 : 크로아티아 알파벳 (최대 100글자)
출력 : int 몇 개의 크로아티아 알파벳?
조건 : 단어에 몇 개의 크로아티아 알파벳이??
c- , dz= , d- , lj, nj, s= , z=
문제풀이 : 각 단어가 들어가는 횟수를 세자.
어떻게? 해당하는 단어를 찾으면 걔 빼고 뒤부터 돌아야되잖아.
해시맵으로 특정 단어 등장 횟수를 세면 되려나.
아니지 리플레이스올해서 단일 문자 치환을 해서 길이를 세면 되나.
음...
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class B2941 {
    public static int countCroatianAlphabets(String word) {
        // 크로아티아 알파벳을 단일 문자로 치환
        String[] croatianAlphabets = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for (String croAlpha : croatianAlphabets) {
            word = word.replaceAll(croAlpha, "x");
        }

        // 변환된 문자열의 길이를 반환
        return word.length();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int result = countCroatianAlphabets(input);

        System.out.println(result);
    }
}