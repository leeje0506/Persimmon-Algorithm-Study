import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



// 1번의 교환으로 만들 수 있는 가장 긴 연속 사탕의 길이를 찾는 것
// 초기 상태로 가장 긴 연속된 같은 색상의 사탕 길이를 확인
// 보드의 모든 인접칸(오른쪽,아래) 사탕을 교환함.
// 교환한 상태의 가장 긴 연속된 같은 색상의 사탕 길이를 확인.
// 교환하기 전의 상태로 되돌려 놓는다.
// 최대 길이를 업데이트!
public class B3085 { // Main 클래스 정의
    private static int N; // 보드의 크기를 저장할 변수 N 선언
    private static char[][] board; // 보드의 상태를 저장할 2차원 배열 board 선언

    public static void main(String[] args) throws IOException { // main 메소드 시작, IOException 예외 처리 필요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력을 위한 BufferedReader 객체 생성
        N = Integer.parseInt(br.readLine()); // 첫 번째 줄을 읽어 정수로 변환하여 N에 저장
        board = new char[N][N]; // N*N 크기의 char 배열 board 초기화

        for (int i = 0; i < N; i++) { // N번 반복
            String line = br.readLine(); // 한 줄씩 읽기
            for (int j = 0; j < N; j++) { // 각 줄의 문자를 배열에 저장
                board[i][j] = line.charAt(j); // i번째 줄의 j번째 문자를 board[i][j]에 저장
            }
        }

        System.out.println(findMaxCandies()); // findMaxCandies 메소드 호출 결과를 출력
    }

    private static int findMaxCandies() { // 교환 후 최대 사탕 수를 찾는 메소드
        int maxCandies = 0; // 최대 사탕 수를 저장할 변수 초기화
        for (int i = 0; i < N; i++) { // 모든 행에 대해 반복
            for (int j = 0; j < N; j++) { // 모든 열에 대해 반복
                if (j < N - 1) { // 오른쪽 칸과 교환 가능한지 확인
                    swap(i, j, i, j + 1); // 현재 칸과 오른쪽 칸 교환
                    maxCandies = Math.max(maxCandies, maxCandyLength()); // 교환 후 최대 연속 길이 계산 및 최대값 갱신
                    swap(i, j, i, j + 1); // 원래 상태로 복구
                }
                if (i < N - 1) { // 아래 칸과 교환 가능한지 확인
                    swap(i, j, i + 1, j); // 현재 칸과 아래 칸 교환
                    maxCandies = Math.max(maxCandies, maxCandyLength()); // 교환 후 최대 연속 길이 계산 및 최대값 갱신
                    swap(i, j, i + 1, j); // 원래 상태로 복구
                }
            }
        }
        return maxCandies; // 계산된 최대 사탕 수 반환
    }

    private static void swap(int x1, int y1, int x2, int y2) { // 두 위치의 사탕을 교환하는 메소드
        char temp = board[x1][y1]; // 첫 번째 위치의 사탕을 temp에 임시 저장
        board[x1][y1] = board[x2][y2]; // 두 번째 위치의 사탕을 첫 번째 위치로 이동
        board[x2][y2] = temp; // temp에 저장된 사탕을 두 번째 위치로 이동
    }

    private static int maxCandyLength() { // 보드 전체에서 최대 연속 사탕 길이를 계산하는 메소드
        int maxLength = 0; // 최대 길이를 저장할 변수 초기화
        for (int i = 0; i < N; i++) { // 모든 행 및 열에 대해 반복
            int rowCount = 1, colCount = 1; // 연속 카운트 초기화
            for (int j = 1; j < N; j++) { // 각 행과 열의 연속 길이 계산
                // 행 검사
                if (board[i][j] == board[i][j - 1]) {
                    rowCount++;
                } else {
                    maxLength = Math.max(maxLength, rowCount);
                    rowCount = 1;
                }
                // 열 검사
                if (board[j][i] == board[j - 1][i]) {
                    colCount++;
                } else {
                    maxLength = Math.max(maxLength, colCount);
                    colCount = 1;
                }
            }
            maxLength = Math.max(maxLength, rowCount); // 행의 마지막 부분 처리
            maxLength = Math.max(maxLength, colCount); // 열의 마지막 부분 처리
        }
        return maxLength; // 계산된 최대 길이 반환
    }
}