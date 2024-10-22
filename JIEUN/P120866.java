class P120866 {
    public int solution(int[][] board) {
        int n = board.length;
        boolean[][] danger = new boolean[n][n];
        
        // 8방향 탐색을 위한 방향 벡터
        int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        // 지뢰 찾기 및 위험지역 표시
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {  // 지뢰 발견
                    danger[i][j] = true;  // 지뢰 위치도 위험지역으로 표시
                    for (int d = 0; d < 8; d++) {  // 8방향 탐색
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                            danger[nx][ny] = true;
                        }
                    }
                }
            }
        }
        
        // 안전지역 개수 계산
        int safeCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!danger[i][j] && board[i][j] == 0) {
                    safeCount++;
                }
            }
        }
        
        return safeCount;
    }
}
