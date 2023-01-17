#include <cstdio>

int T, N;
long long A[101] = {0, 1, 1, 1, 2, 2};

long long getPN(int n);

int main(){
    scanf("%d", &T);

    for(int t = 0; t < T; t++){
        scanf("%d", &N);
        printf("%lld\n", getPN(N));
    }

    return 0;
}

long long getPN(int n){
    if(A[n])
        return A[n];
    else
        return A[n] = getPN(n-1) + getPN(n-5);
}