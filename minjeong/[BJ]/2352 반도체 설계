package GamnamuStudy;

import java.io.*;
import java.util.*;

public class BJ_2352_반도체설계 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[N];
        lis[0] = arr[0];
        int idx = 1;
        int tmp = 0;
        for (int i = 1; i < N; i++) {
            if (lis[idx - 1] < arr[i]) {
                lis[idx++] = arr[i];
            } else if (lis[0] > arr[i]) {
                lis[0] = arr[i];
            } else {
                tmp = Arrays.binarySearch(lis, 0, idx, arr[i]);
                lis[tmp < 0 ? (-tmp - 1) : tmp] = arr[i];
            }
        }

        System.out.println(idx);
    }
}
