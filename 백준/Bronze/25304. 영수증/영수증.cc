#include <cstdio>

int X, N, a, b, sum;

int main(){
    scanf("%d %d", &X, &N);
    for(int i = 0; i < N; i++){
        scanf("%d %d", &a, &b);
        sum += a*b;
    }
    if(sum == X)
        printf("Yes\n");
    else
        printf("No\n");
    return 0;
}