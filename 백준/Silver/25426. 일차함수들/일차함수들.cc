#include <cstdio>
#include <algorithm>

int N;
long long A[100000], B;

int main(){
    scanf("%d", &N);

    int a, b;
    for(int i = 0; i < N; i++){
        scanf("%d %d", &a, &b);
        A[i] = a;
        B += b;
    }

    std::sort(A, A+N);

    for(int i = 0; i < N; i++){
        B = B + A[i] * (i + 1);
    }

    printf("%lld\n", B);

    return 0;
}