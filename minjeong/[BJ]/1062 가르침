package GamnamuStudy;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1062_가르침 {
    static int N, K;
    static int max = Integer.MIN_VALUE;
    static boolean[] isChecked; // 알파벳
    static String[] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        words = new String[N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");
            words[i] = str;
        }

        if(K < 5 | K == 26){
            int result = K < 5 ? 0 : N;
            System.out.println(result);
            return;
        }

        isChecked = new boolean[26];
        isChecked['a' - 'a'] = true;
        isChecked['c' - 'a'] = true;
        isChecked['i' - 'a'] = true;
        isChecked['n' - 'a'] = true;
        isChecked['t' - 'a'] = true;

        backtracking(0, 0);

        System.out.println(max);
    }

    private static void backtracking(int num, int len) {
        if(len == K - 5){
            int cnt = 0;

            for(int i = 0; i < N; i++) {
                boolean isRead = true;
                for(int j = 0; j < words[i].length(); j++) {
                    if(!isChecked[words[i].charAt(j) - 'a']) {
                        isRead = false;
                        break;
                    }
                }
                if(isRead) cnt++;
            }
            max = Math.max(cnt, max);
            return;
        }

        for(int i = num; i < 26; i++){
            if(!isChecked[i]){
                isChecked[i] = true;
                backtracking(i, len + 1);
                isChecked[i] = false;
            }
        }
    }
}
