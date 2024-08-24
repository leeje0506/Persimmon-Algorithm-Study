class Solution {
    public int solution(int[][] dots) {
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        int yMin = Integer.MAX_VALUE;
        int yMax = Integer.MIN_VALUE;
        
        // 각 좌표의 x값과 y값의 최소, 최대값을 구함
        for (int[] dot : dots) {
            xMin = Math.min(xMin, dot[0]);
            xMax = Math.max(xMax, dot[0]);
            yMin = Math.min(yMin, dot[1]);
            yMax = Math.max(yMax, dot[1]);
        }
        
        // 가로와 세로 길이를 구함
        int width = xMax - xMin;
        int height = yMax - yMin;
        
        // 넓이를 계산
        return width * height;
    }
}
