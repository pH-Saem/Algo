#include <iostream>

int main(){
    long long N, M, diff;
    scanf("%lld %lld", &N, &M);
    diff = N-M;
    printf("%lld", diff>0?diff:diff*(-1));
    return 0;
}