#include <cstdio>

int N, M, a, K;
int others, max, min;

int main(){
    scanf("%d %d %d %d", &N, &M, &a, &K);

    others = a - K;
    max = others < N ? others + 1 : N;
    min = others / M;

    if(others % M)
        min++;

    printf("%d %d\n", max, min + 1);

    return 0;
}