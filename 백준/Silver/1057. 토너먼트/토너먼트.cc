#include <cstdio>

int N, A, B, round;

int main(){
    scanf("%d %d %d", &N, &A, &B);
    for(int i = 1; i <= N; i = i<<1){
        if(A != B){
            A = (A+1)>>1;
            B = (B+1)>>1;
        } else{
            break;
        }
        round++;
    }

    if(A == B){
        printf("%d\n", round);
    } else{
        printf("-1\n");
    }

    return 0;
}