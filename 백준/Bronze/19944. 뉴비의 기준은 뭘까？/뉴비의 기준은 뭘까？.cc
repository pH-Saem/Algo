#include <cstdio>

int N, M;

int main(){
    scanf("%d %d", &N, &M);
    if(M == 1 || M == 2)
        printf("NEWBIE!\n");
    else if(M <= N)
        printf("OLDBIE!\n");
    else
        printf("TLE!\n");
    return 0;
}