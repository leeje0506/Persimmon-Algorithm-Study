// class Solution {
//     public int[] solution(String[] keyinput, int[] board) {
//         int[] position = {0, 0}; // 초기 위치는 (0, 0)
        
//         // 이동을 나타내는 방향 배열 (상, 하, 좌, 우)
//         // dr: y축 변화, dc: x축 변화
//         // up, down, left, right
//         int[] dr = {1, -1, 0, 0}; 
//         int[] dc = {0, 0, -1, 1};
        
//         // 최대 이동할 수 있는 범위 계산
//         int xLimit = board[0] / 2;
//         int yLimit = board[1] / 2;
        
//         for (String key : keyinput) {
//             int nextX = position[0];
//             int nextY = position[1];
            
//             if (key.equals("up")) {
//                 nextY += dr[0]; // 위로 이동하면 y값 증가
//             } else if (key.equals("down")) {
//                 nextY += dr[1]; // 아래로 이동하면 y값 감소
//             } else if (key.equals("left")) {
//                 nextX += dc[2]; // 왼쪽으로 이동하면 x값 감소
//             } else if (key.equals("right")) {
//                 nextX += dc[3]; // 오른쪽으로 이동하면 x값 증가
//             }
            
//             // 이동한 좌표가 범위를 넘지 않도록 제한
//             if (Math.abs(nextX) <= xLimit && Math.abs(nextY) <= yLimit) {
//                 position[0] = nextX;
//                 position[1] = nextY;
//             }
//         }
        
//         return position;
//     }
// }



class P120861 {
    public int[] solution(String[] keyinput, int[] board) {
        int[] position = {0, 0}; // 초기 위치는 (0, 0)
        
        // 최대 이동할 수 있는 범위 계산
        int xLimit = board[0] / 2;
        int yLimit = board[1] / 2;
        
        for (String key : keyinput) {
            if (key.equals("up")) {
                if (position[1] + 1 <= yLimit) {
                    position[1]++;
                }
            } else if (key.equals("down")) {
                if (position[1] - 1 >= -yLimit) {
                    position[1]--;
                }
            } else if (key.equals("left")) {
                if (position[0] - 1 >= -xLimit) {
                    position[0]--;
                }
            } else if (key.equals("right")) {
                if (position[0] + 1 <= xLimit) {
                    position[0]++;
                }
            }
        }
        
        return position;
    }
}
