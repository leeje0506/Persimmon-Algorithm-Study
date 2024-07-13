import java.io.*;
import java.util.*;

public class Main {
    static int M, N, H; // 가로(M), 세로(N), 높이(H) 크기 저장할 변수
    static int[][][] box; // 토마토 상자 3차원 배열
    static int[] dx = {1, -1, 0, 0, 0, 0}; // x축 이동 배열 (오른쪽, 왼쪽)
    static int[] dy = {0, 0, 1, -1, 0, 0}; // y축 이동 배열 (위, 아래)
    static int[] dz = {0, 0, 0, 0, 1, -1}; // z축 이동 배열 (위, 아래)

    // 토마토 클래스 선언 (x, y, z 좌표 저장)
    static class Tomato {
        int x, y, z;
        public Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    // BFS 탐색 함수
    public static int bfs() {
        Queue<Tomato> queue = new LinkedList<>(); // BFS를 위한 큐
        int freshTomatoes = 0; // 익지 않은 토마토 수

        // 초기 큐 설정 (익은 토마토 위치 큐에 추가)
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 1) {
                        queue.add(new Tomato(x, y, z));
                    } else if (box[z][y][x] == 0) {
                        freshTomatoes++;
                    }
                }
            }
        }

        // 익지 않은 토마토가 처음부터 없으면 0일 반환
        if (freshTomatoes == 0) {
            return 0;
        }

        int days = 0; // 날짜 카운트

        // BFS 시작
        while (!queue.isEmpty()) {
            int size = queue.size();
            days++; // 하루 증가
            for (int i = 0; i < size; i++) {
                Tomato t = queue.poll(); // 큐에서 토마토 하나 꺼냄

                // 6방향 탐색
                for (int d = 0; d < 6; d++) {
                    int nx = t.x + dx[d];
                    int ny = t.y + dy[d];
                    int nz = t.z + dz[d];

                    // 범위 내에 있고 익지 않은 토마토이면 익히기
                    if (nx >= 0 && ny >= 0 && nz >= 0 && nx < M && ny < N && nz < H && box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        queue.add(new Tomato(nx, ny, nz)); // 익은 토마토 큐에 추가
                        freshTomatoes--; // 익지 않은 토마토 수 감소
                    }
                }
            }
        }

        // 남아있는 익지 않은 토마토가 없으면 걸린 일수 반환, 아니면 -1 반환
        return (freshTomatoes == 0) ? days - 1 : -1;
    }

    // 메인 함수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로 크기 입력
        N = Integer.parseInt(st.nextToken()); // 세로 크기 입력
        H = Integer.parseInt(st.nextToken()); // 높이 입력

        box = new int[H][N][M]; // 토마토 상자 3차원 배열 초기화

        // 토마토 상태 입력받기
        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                st = new StringTokenizer(br.readLine());
                for (int x = 0; x < M; x++) {
                    box[z][y][x] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 결과 출력
        System.out.println(bfs());
    }
}
