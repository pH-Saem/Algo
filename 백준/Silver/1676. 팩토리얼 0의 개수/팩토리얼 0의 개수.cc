#include <cstdio>

int N;

int main(){
    scanf("%d", &N);
    printf("%d\n", N/5 + N/25 + N/125);
    return 0;
}