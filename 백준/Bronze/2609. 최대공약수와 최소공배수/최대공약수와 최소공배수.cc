#include <cstdio>

int hojae(int a, int b);

int main(){
    int a, b, c;
    scanf("%d %d", &a, &b);
    c = hojae(a, b);
    printf("%d\n%d\n", c, a*b/c);

    return 0;
}

int hojae(int a, int b){
    if(a % b != 0)
        return hojae(b, a % b);
    else
        return b;
}