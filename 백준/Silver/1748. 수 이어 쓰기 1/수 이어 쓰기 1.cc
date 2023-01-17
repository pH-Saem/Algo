#include <cstdio>

int N, cnt, length = 1, t = 1;

int main(){
    scanf("%d", &N);
    while(N >= t*10){
        cnt = cnt + length*9*t;
        length++;
        t *= 10;
    }
    cnt = cnt + length*(N - t + 1);
    printf("%d\n", cnt);

    return 0;
}