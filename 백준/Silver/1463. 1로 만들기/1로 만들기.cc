#include <cstdio>

int A[1000001], N;

int getMinCount(int index);

int main(){
    A[2] = 1, A[3] = 1;

    scanf("%d", &N);

    for(int i = 4; i <= N; i++){
        A[i] = getMinCount(i);
    }

    printf("%d\n", A[N]);

    return 0;
}

int getMinCount(int index){
    int MinCount = 2000000;
    if(index%3 == 0)
        MinCount = A[index/3] + 1;
    if(index%2 == 0 && A[index/2] + 1 < MinCount)
        MinCount = A[index/2] + 1;
    if(A[index-1] + 1 < MinCount)
        MinCount = A[index-1] + 1;
    return MinCount;
}