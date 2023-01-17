#include <cstdio>

long long at(int a, int b);

int main(){
    int a, b;
    scanf("%d %d", &a, &b);
    printf("%lld\n", at(a, b));
    return 0;
}

long long at(int a, int b){
    return ((long long)a+b)*(a-b);
}