#include <cstdio>

long long X, Y, Z, answer;

int main(){
    scanf("%lld %lld", &X, &Y);

    Z = (100*Y)/X;
    if(Z == 100 || Z == 99)
        answer = -1;
    else{
        answer = ((Z + 1)*X - 100 * Y)/(99 - Z);
        if(((Z + 1)*X - 100 * Y)%(99 - Z))
            answer++;
    }
    printf("%lld\n", answer);
    
    return 0;
}