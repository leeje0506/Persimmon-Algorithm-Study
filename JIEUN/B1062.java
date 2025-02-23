import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String[] words;
    static boolean[] learned;
    static int maxCount = 0;
    static final char[] REQUIRED = {'a', 'n', 't', 'i', 'c'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 기본 필수 문자 (a, n, t, i, c)를 배우지 못하면 단어를 읽을 수 없음
        if (K < 5) {
            System.out.println(0);
            return;
        }

        words = new String[N];
        learned = new boolean[26]; // 알파벳 26개 (a~z)

        // 필수 문자 "antic" 학습 표시
        for (char c : REQUIRED) {
            learned[c - 'a'] = true;
        }

        // 단어 입력 (앞의 "anta", 뒤의 "tica" 제거)
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words[i] = word.substring(4, word.length() - 4); // "anta"와 "tica" 제거
        }

        // 백트래킹 시작: K-5개의 알파벳을 선택
        selectLetters(0, 0);

        // 최댓값 출력
        System.out.println(maxCount);
    }

    // 백트래킹: 알파벳 선택
    public static void selectLetters(int index, int count) {
        // K-5개의 문자를 선택했으면 읽을 수 있는 단어 개수 세기
        if (count == K - 5) {
            maxCount = Math.max(maxCount, countReadableWords());
            return;
        }

        // a~z 중 필수 문자 "antic" 제외한 나머지 문자 선택
        for (int i = index; i < 26; i++) {
            if (!learned[i]) {
                learned[i] = true; // 선택
                selectLetters(i + 1, count + 1);
                learned[i] = false; // 원복
            }
        }
    }

    // 현재 배운 글자로 몇 개의 단어를 읽을 수 있는지 계산
    public static int countReadableWords() {
        int count = 0;
        for (String word : words) {
            boolean canRead = true;
            for (char c : word.toCharArray()) {
                if (!learned[c - 'a']) { // 배운 문자에 없으면 읽을 수 없음
                    canRead = false;
                    break;
                }
            }
            if (canRead) count++;
        }
        return count;
    }
}
