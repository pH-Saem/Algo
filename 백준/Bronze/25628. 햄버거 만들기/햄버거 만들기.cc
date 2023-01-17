#include <cstdio>

int main(){
    int A, B, answer;
    scanf("%d %d", &A, &B);
    A = A >> 1;
    if(A <= B)
        answer = A;
    else
        answer = B;
    printf("%d\n", answer);

    return 0;
}