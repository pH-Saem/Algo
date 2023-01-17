#include <cstdio>
#include <algorithm>

int N, M;
int A[100000];
int input;

int BinarySearch(int target);

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++)
        scanf("%d", &A[i]);
    
    std::sort(A, A+N);

    scanf("%d", &M);
    for(int i = 0; i < M; i++){
        scanf("%d", &input);
        printf("%d\n", BinarySearch(input));
    }

    return 0;
}

int BinarySearch(int target){
    int L = 0, R = N, M;
    while(1){
        M = (L + R) / 2;
        if(A[M] == target)
            return 1;
        if(A[M] < target){
            L = M + 1;
        }else{
            R = M;
        }

        if(L >= R)
            break;
    }

    return 0;
}