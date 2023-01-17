#include <cstdio>

int a, b, c, award;

int main(){
    scanf("%d %d %d", &a, &b, &c);

    if(a == b && b == c)
        award = 10000 + a*1000;
    else if(a != b && b != c && a != c){
        award = a > b ? a : b;
        award = award > c ? award : c;
        award *= 100;
    }else if(a == b)
        award = 1000 + a*100;
    else if(a == c)
        award = 1000 + a*100;
    else if(b == c)
        award = 1000 + b*100;
    
    printf("%d\n", award);

    return 0;
}