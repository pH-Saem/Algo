#include <cstdio>

int N, input;
int A[10001];

int main(){
    scanf("%d", &N);

    for(int i = 0; i < N; i++){
        scanf("%d", &input);
        A[input]++;
    }

    for(int i = 1; i < 10001; i++){
        while(A[i]--)
            printf("%d\n", i);
    }

    return 0;
}