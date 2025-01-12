class P120816 {
    public int solution(int slice, int n) {
        int answer = 0;
        
        //2~10 중에 원하는 조각으로 잘라줌.
        //n명의 사람이 최소 1조각 이상 피자를 먹으려면,, 최소 몇 판?
        
        if(n%slice==0){
            answer = n/slice;
        }else{
            answer = n/slice + 1;
        }
        
        
        return answer;
    }
}
