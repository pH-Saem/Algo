#include <cstdio>
#include <algorithm>

using namespace std;

int K, N;
int A[10000];

int binarySearch(int target);
bool isLinesCountsOverTarget(int target, long long M);

int main(){
    scanf("%d %d", &K, &N);
    for(int i = 0; i < K; i++)
        scanf("%d", &A[i]);
    
    sort(A, A+K);

    printf("%d\n", binarySearch(N));

    return 0;
}

int binarySearch(int target){
    long long L = 1, R = A[K-1], M;
    int ans;

    while(1){
        M = (L + R)/2;
        if(isLinesCountsOverTarget(target, M)){
            L = M + 1;
            ans = M;
        }else{
            R = M;
        }

        if(L >= R){
            if(isLinesCountsOverTarget(target, R))
                ans = R;
            break;
        }
    }
    return ans;
}

bool isLinesCountsOverTarget(int target, long long M){
    int lines, cnt = 0;
    for(int i = K - 1; i >= 0; i--){
        lines = A[i] / M;
        if(lines == 0)
            break;
        else
            cnt += lines;
        
        if(cnt >= target)
            return true;
    }
    return false;
}