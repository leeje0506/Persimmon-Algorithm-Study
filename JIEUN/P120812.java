class P120812 {
    public int solution(int[] array) {
        int answer = 0;
        int [] number = new int[1000];
        for(int i=0; i<array.length; i++){
            number[array[i]]++;
        }
        
        // 최빈수 찾기
        int maxFrequency = 0;
        boolean isUnique = true; // 최빈수가 유일한지 확인하는 플래그
        
        for (int i = 0; i < number.length; i++) {
            if (number[i] > maxFrequency) {
                maxFrequency = number[i];
                answer = i;
                isUnique = true; // 새로운 최빈수가 발견되었으므로 유일하다고 가정
            } else if (number[i] == maxFrequency) {
                isUnique = false; // 동일한 빈도를 가진 다른 숫자가 있으면 유일하지 않음
            }
        }

        // 최빈수가 여러 개일 경우 -1 반환
        if (!isUnique) {
            return -1;
        }
        return answer;
    }
}
