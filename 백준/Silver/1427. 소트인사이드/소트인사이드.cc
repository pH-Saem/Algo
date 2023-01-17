#include <cstdio>

int N;

int sortInside(int num);

int main(){
    scanf("%d", &N);
    printf("%d\n", sortInside(N));
    return 0;
}

int sortInside(int num){
    int A[10] = {0, }, result = 0;
    while(num){
        A[num%10]++;
        num /= 10;
    }

    for(int i = 9; i >= 0; i--){
        while(A[i]--){
            result = result*10 + i;
        }
    }

    return result;
}