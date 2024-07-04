import java.util.Scanner;

public class B2563 {
	
	public static int [][] board = new int[100][100];
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner (System.in);
		int T = scanner.nextInt();
		int sum =0;
		
		for(int t=1; t<=T; t++) {
			int sr = scanner.nextInt();
			int sc = scanner.nextInt();
			int er = sr +10;
			int ec = sc +10;
			
			for(int r=sr; r<er; r++) {
				for(int c=sc; c<ec; c++) {
					board[r][c]=1;
				}
			}
		}
		
		
		
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(board [r][c]==1) {
					sum += board[r][c];
				}
			}
		}
		System.out.println(sum);
	}
}
