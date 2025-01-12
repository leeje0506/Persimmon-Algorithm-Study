package GamnamuStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_12761_돌다리 {
    static int[] arr;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[100001];
        check = new boolean[100001];

        bfs(A, B, N, M);

        System.out.println(arr[M]);
    }

    public static void bfs(int A, int B, int N, int M){
        Queue<Integer> q = new LinkedList<>();
        q.add(N);
        check[N] = true;

        while(!q.isEmpty()){
            int tmp = q.poll();
            int[] pow = {tmp-1, tmp+1, tmp-A, tmp+A, tmp-B, tmp+B, tmp*A, tmp*B};

            for(int i = 0; i < 8; i++){
                if(pow[i] >= 0 && pow[i] <= 100000 && !check[pow[i]]){
                    check[pow[i]] = true;
                    arr[pow[i]] = arr[tmp] + 1;
                    q.add(pow[i]);
                }
            }

            if(arr[M] > 0) break;
        }
    }
}
