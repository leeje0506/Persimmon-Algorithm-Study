import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B5597 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        //출석번호는 1번부터
		boolean [] std = new boolean [31];
		
        //28명의 출석한 학생
		for(int i=0; i<28; i++) {
			int idx = Integer.parseInt(br.readLine());
			std[idx] = true;
		
		}
        
        //출석번호 1번부터
		for(int i=1; i<31; i++) {
			if(std[i]==false) {
				System.out.println(i);
			}
		}
		
		
	}//main
}//class
