#include <cstdio>

int K, A, B, temp;

int main(){
    scanf("%d", &K);
    A = 1; B = 0;
    for(int i = 0; i < K; i++){
        temp = A;
        A = B;
        B += temp;
    }
    printf("%d %d\n", A, B);

    return 0;
}