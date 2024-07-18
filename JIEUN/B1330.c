#include <stdio.h>

int main() {
    int A, B;
    
    // 두 정수를 입력받음
    scanf("%d %d", &A, &B);
    
    // A가 B보다 큰 경우
    if (A > B) {
        printf(">\n");
    }
    // A가 B보다 작은 경우
    else if (A < B) {
        printf("<\n");
    }
    // A와 B가 같은 경우
    else {
        printf("==\n");
    }

    return 0;
}
