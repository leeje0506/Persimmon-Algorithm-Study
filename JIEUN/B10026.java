import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, RGB, notRGB;
	public static String [][] board;
	public static boolean [][] visited;
	public static int [] dr = {-1, 1, 0, 0};
	public static int [] dc = {0,0,-1,1};

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		board = new String [N][N];
		visited = new boolean [N][N];
		
		for(int r=0; r<N; r++) {
			String str = br.readLine();
			for(int c=0; c<N; c++) {
				board[r][c] = String.valueOf(str.charAt(c));
			}
		}
		
		//적록색맹이 아닌 경우
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {
					dfs(r,c);
					RGB++;
				}			
			}
		}
						
		//적록색맹인 경우
        //R을 G로 바꾼다 (반대도 가능. 어차피 같은 색으로 보니까.)
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(board[r][c].equals("R")) {
					board[r][c] = "G";
				}
			}
		}
		
        //visited배열 초기화
		visited = new boolean [N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!visited[r][c]) {					
					dfs(r,c);
					notRGB++;
				}			
			}
		}
		
		
		System.out.println(RGB + " " + notRGB);

	}
	
	public static void dfs(int r, int c) {
		visited[r][c] = true;
				
		for(int d=0; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr>=0 && nc>=0 && nr <N && nc<N && !visited[nr][nc]) {
				//같은 색상이면 같은 구역
				if(board[nr][nc].equals(board[r][c])) {
					visited[nr][nc] = true;
					dfs(nr,nc);
					
				}	

			}
		}
	}
}
