#include <stdio.h>

int main() {
    int score;
    
    // 시험 점수를 입력받음
    scanf("%d", &score);
    
    // 성적을 계산하여 출력
    if (score >= 90 && score <= 100) {
        printf("A\n");
    } else if (score >= 80 && score <= 89) {
        printf("B\n");
    } else if (score >= 70 && score <= 79) {
        printf("C\n");
    } else if (score >= 60 && score <= 69) {
        printf("D\n");
    } else {
        printf("F\n");
    }
    
    return 0;
}
