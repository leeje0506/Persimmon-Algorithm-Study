class P120844 {
    public int[] solution(int[] numbers, String direction) {
        int[] answer = {};
        
        if (direction.equals("left")) {
            left(numbers);  // 배열을 왼쪽으로 이동
        } else {
            right(numbers);  // 배열을 오른쪽으로 이동
        }
        
        answer = numbers;
        
        return answer;  // 변경된 원본 배열 반환
    }
    
    // 배열을 왼쪽으로 이동시키는 메서드
    public void left(int[] array) {
        int first = array[0];  // 첫 번째 요소를 임시로 저장
        for (int i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];  // 각 요소를 한 칸 앞으로 이동
        }
        array[array.length - 1] = first;  // 첫 번째 요소를 마지막 위치로 이동
    }
    
    // 배열을 오른쪽으로 이동시키는 메서드
    public void right(int[] array) {
        int last = array[array.length - 1];  // 마지막 요소를 임시로 저장
        for (int i = array.length - 1; i > 0; i--) {
            array[i] = array[i - 1];  // 각 요소를 한 칸 뒤로 이동
        }
        array[0] = last;  // 마지막 요소를 첫 번째 위치로 이동
    }
}
