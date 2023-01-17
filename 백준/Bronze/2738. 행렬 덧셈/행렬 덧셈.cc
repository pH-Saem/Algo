#include <cstdio>

int main(){
    int N, M, *A, temp;
    scanf("%d %d", &N, &M);
    A = new int[N*M];
    for(int i = 0; i < N*M; i++){
        scanf("%d", &A[i]);
    }
    for(int i = 0; i < N*M; i++){
        scanf("%d", &temp);
        A[i] += temp;
    }
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            printf("%d ", A[i*M + j]);
        }
        printf("\n");
    }
    return 0;
}