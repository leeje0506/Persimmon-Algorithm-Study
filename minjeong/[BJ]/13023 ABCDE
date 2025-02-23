package GamnamuStudy;

import java.io.*;
import java.util.*;

public class BJ_13023_ABCDE {
    static int N, M, answer;
    static boolean[] isChecked;
    static ArrayList<Integer>[] array;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isChecked = new boolean[N];
        array = new ArrayList[N];

        for(int i = 0; i < N; i++) {
            array[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            array[a].add(b);
            array[b].add(a);
        }

        answer = 0;
        for(int i = 0; i < N; i++){
            if(answer != 1) dfs(i, 1);
        }
    }

    public static void dfs(int start, int depth) {
        if(depth == 5) {
            answer = 1;
            return;
        }

        isChecked[start] = true;

        for(int i : array[start]) {
            if(!isChecked[i]) {
                dfs(i, depth + 1);
            }
        }

        isChecked[start] = false;
    }
}
