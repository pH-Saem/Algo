#include <cstdio>

int N, A[1000], D[1000];
int Answer, max;

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &A[i]);
    }
    for(int i = N-1; i >= 0; i--){
        max = 0;
        for(int j = i; j < N; j++){
            if(max < D[j] && A[i] < A[j])
                max = D[j];
        }
        D[i] = 1 + max;
        if(Answer < D[i])
            Answer = D[i];
    }

    printf("%d\n", Answer);

    return 0;
}