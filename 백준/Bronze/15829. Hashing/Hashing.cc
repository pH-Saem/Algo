#include <cstdio>

const int r = 31;
const long long M = 1234567891;

int L, a;
unsigned long long H, ri = 1;
char S[51];

int main(){
    scanf("%d", &L);
    scanf("%s", S);

    for(int i = 0; i < L; i++){
        a = S[i] - 96;
        if(i)
            ri *= r;
        H += (a%M)*(ri%M);
    }
    printf("%llu\n", H);

    return 0;
}