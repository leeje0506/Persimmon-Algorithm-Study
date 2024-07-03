import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


//1은 이동 가능, 0은 이동 불가능(벽)
//최소의 칸 수 출력. 
public class Main {
	
	public static StringBuilder sb = new StringBuilder();

	public static int N,M,V,s,e;
	public static int [][] miro;
	public static boolean [][] visited;
	public static Queue<Node> que = new LinkedList<>();
	public static int [] dr = {-1,1,0,0};
	public static int [] dc = {0,0,1,-1};
	public static int cnt=0;
	
   
    public static class Node{
    	int s;
    	int e;

		public Node(int s, int e) {
			this.s = s;
			this.e = e;
		}
    }//Node
    
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        
        miro = new int[N][M];
        visited = new boolean [N][M];
     
        for(int r=0; r<N; r++) {
        	String str = br.readLine();
        	for(int c=0; c<M; c++) {
        		miro[r][c] = str.charAt(c)-'0';
        		visited[r][c] = false;
        	}
        }
        
        
        bfs(0,0);
       
        System.out.println(miro[N-1][M-1]);

    }//main
    

    
    public static void bfs(int s, int e) {
    	que.add(new Node(s,e));
    	visited[s][e] = true;
    	
    	while(!que.isEmpty()) {
    		Node node = que.poll();
    		
    		for(int d=0; d<4; d++) {
        		int nr = node.s +dr[d];
        		int nc = node.e + dc[d];
        		//범위를 벗어나지 않고
        		if(nr>=0 && nc>=0 && nr<N && nc<M) {
        			//방문하지 않았고, 이동이 가능한 곳
        			if(visited[nr][nc]==false && miro[nr][nc]==1 ) {
        				
        				//다음 탐색 지점 큐에 추가
        				que.add(new Node(nr,nc));
        				
        				miro[nr][nc] = miro[node.s][node.e] +1;
        				
        				//다음 탐색 지점 탐색처리
        				visited[nr][nc] = true;
        				
        			}
        		}
        	}
    	}
    	
    }//bfs
    
}//class
