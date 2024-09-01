import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstWord = br.readLine();
        String secondWord = br.readLine();
        
        // 알파벳의 개수는 26개이므로 각 단어의 문자 빈도를 저장할 배열 생성
        int[] firstFreq = new int[26];
        int[] secondFreq = new int[26];
        
        // 첫 번째 단어의 문자 빈도 계산
        for (char c : firstWord.toCharArray()) {
            firstFreq[c - 'a']++;
        }
        
        // 두 번째 단어의 문자 빈도 계산
        for (char c : secondWord.toCharArray()) {
            secondFreq[c - 'a']++;
        }
        
        int removeCount = 0;
        
        // 두 배열의 빈도 차이를 계산하여 제거해야 하는 문자의 개수 합산
        for (int i = 0; i < 26; i++) {
            removeCount += Math.abs(firstFreq[i] - secondFreq[i]);
        }
        
        // 결과 출력
        System.out.println(removeCount);
    }
}
