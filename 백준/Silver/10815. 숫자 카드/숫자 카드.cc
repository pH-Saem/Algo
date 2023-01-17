#include <cstdio>

int N, M;
int A[20000001];

int main(){
    int ind;

    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &ind);
        A[10000000 + ind] = 1;
    }

    scanf("%d", &M);
    for(int i = 0; i < M; i++){
        scanf("%d", &ind);
        printf("%d ", A[10000000 + ind]);
    }
    printf("\n");

    return 0;
}