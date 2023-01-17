#include <cstdio>

int N;

int main(){
    scanf("%d", &N);
    int lc = N / 4;
    for(int i = 0; i < lc; i++)
        printf("long ");
    printf("int\n");
    return 0;
}