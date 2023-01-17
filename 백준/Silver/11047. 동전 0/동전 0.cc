#include <cstdio>

int N, K, A[1000000], cnt, ind = -1;

int main(){
    scanf("%d %d", &N, &K);

    for(int i = 0; i < N; i++){
        scanf("%d", &A[i]);
        if(ind == -1 && A[i] > K)
            ind = i-1;
    }

    if(ind == -1)
        ind = N-1;

    for(int i = ind; i >= 0; i--){
        cnt += K/A[ind];
        K %= A[ind];
        ind--;
    }

    printf("%d\n", cnt);

    return 0;
}