#include <cstdio>

int N, fr, input, d;

int gcd(int a, int b){
    if(b == 0)
        return a;
    return gcd(b, a%b);
}

int main(){
    scanf("%d", &N);
    scanf("%d", &fr);
    for(int i = 0; i < N-1; i++){
        scanf("%d", &input);
        d = gcd(fr, input);
        printf("%d/%d\n", fr/d, input/d);
    }
    return 0;
}