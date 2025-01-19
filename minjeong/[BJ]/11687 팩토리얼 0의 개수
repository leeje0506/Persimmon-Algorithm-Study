package GamnamuStudy;

import java.util.Scanner;

public class BJ_11687_팩토리얼0의개수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();

        System.out.println(binary(M, 1, 1000000000));
    }

    public static int binary(int k, int l, int r){
        boolean check = false;

        while(l <= r){
            int mid = (l+r) / 2;
            if(k < zero(mid)){
                r = mid - 1;
            } else if(k == zero(mid)){
                r = mid - 1;
                check = true;
            } else {
                l = mid + 1;
            }
        }

        return check ? l : -1;
    }

    public static int zero(int mid){
        int cnt = 0;

        for(int i = 5; i <= mid; i*=5){
            cnt += mid/i;
        }

        return cnt;
    }
}
