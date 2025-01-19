package GamnamuStudy;

import java.util.Scanner;

public class BJ_1946_신입사원 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 0; t < T; t++){
            int N = sc.nextInt();
            int[] arr = new int[N+1];
            int cnt = 1;

            for(int i = 0; i < N; i++){
                arr[sc.nextInt()] = sc.nextInt();
            }

            // 1등의 면접성적을 저장하여 비교할 것임
            int first = arr[1];

            for(int i = 2; i <= N; i++){
                if(first > arr[i]){
                    first = arr[i];
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}
