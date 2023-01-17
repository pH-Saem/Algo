#include <cstdio>

int A[6] = {1,1,2,2,2,8};
int input;

int main(){

    for(int i = 0; i < 6; i++){
        scanf("%d", &input);
        printf("%d ", A[i] - input);
    }
    printf("\n");

    return 0;
}