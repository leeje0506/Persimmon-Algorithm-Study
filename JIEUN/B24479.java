import jdk.dynalink.beans.StaticClass;

import javax.swing.plaf.metal.MetalIconFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
작성자 : 이지은
작성일시 : 2024-07-4, 목, 14:6
입력 : 정점의 수 n, 간선의 수 m, 시작 정점 r
      다음 m개의 줄에 간선 정보 u v (가중치 1)
출력 : 노드의 방문 순서.
      n개의 줄에 정수 출력. i번째 줄 = 정점 i의 방문 순서. 방문할 수 없는 경우 0.
조건 : 인접 정점은 오름차순으로 방문한다.
문제풀이 : 깊이 우선 탐색. 인접 리스트 사용.
*/

public class B24479 {
    public static ArrayList<Integer>[] graph;
    public static boolean[] visited;
    public static int[] order;
    public static int n, m, r, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        order = new int[n + 1]; // 방문 순서 저장할 배열
        cnt = 1;


        //1. 그래프 초기화
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        //2. 간선 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        //3. 인접 정점 오름차순 정렬
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph[i]);
        }

        //4. 깊이 우선 탐색 진행
        dfs(r);

        //5. 출력
        for (int i = 1; i <= n; i++) {
            System.out.println(order[i]);
        }
    }

    static void dfs(int node) {
        visited[node] = true;
        order[node] = cnt++; //방문 순서 기록

        // 인접 정점 방문
        for(int next : graph[node]){
            if(!visited[next]){
                dfs(next);
            }
    }

    }
}
