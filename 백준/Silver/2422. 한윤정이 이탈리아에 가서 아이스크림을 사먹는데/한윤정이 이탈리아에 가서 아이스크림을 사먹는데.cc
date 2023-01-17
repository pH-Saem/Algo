#include <cstdio>


int N, M, count;
int A[201][201];

int main(){
    scanf("%d %d", &N, &M);

    int a, b;
    for(int i = 0; i < M; i++){
        scanf("%d %d", &a, &b);
        A[a][b] = 1;
        A[b][a] = 1;
    }

    for(int i = 1; i <= N; i++){
        for(int j = i+1; j <= N; j++){
            if(A[i][j] == 1)
                continue;
            for(int k = j+1; k <= N; k++){
                if(A[j][k] == 1 || A[i][k] == 1)
                    continue;
                count++;
            }
        }
    }

    printf("%d\n", count);

    return 0;
}