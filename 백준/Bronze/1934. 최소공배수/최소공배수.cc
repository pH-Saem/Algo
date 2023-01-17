#include <cstdio>

int T, A, B;

int hojae(int a, int b){
    if(a%b)
        return hojae(b, a%b);
    return b;
}

int main(){
    scanf("%d", &T);
    for(int t = 0; t < T; t++){
        scanf("%d %d", &A, &B);
        printf("%d\n", A*B/hojae(A, B));
    }
    return 0;
}