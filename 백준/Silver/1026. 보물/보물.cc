#include <cstdio>
#include <algorithm>

int N, A[50], B[50], answer;

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++)
        scanf("%d", &A[i]);
    for(int i = 0; i < N; i++)
        scanf("%d", &B[i]);

    std::sort(A, A+N);
    std::sort(B, B+N);

    for(int i = 0; i < N; i++)
        answer += A[i] * B[N-i-1];

    printf("%d\n", answer);

    return 0;
}