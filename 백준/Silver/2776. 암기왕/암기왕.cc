#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int T, N, M, input;
vector<int> A;

bool binarySearch(int target){
    int l = 0, r = N-1, m;
    while(l <= r){
        m = (l+r)/2;
        if(A[m] == target)
            return true;
        if(A[m] < target){
            l = m+1;
        } else{
            r = m-1;
        }
    }
    return false;
}

int main(){
    scanf("%d", &T);
    for(int t = 1; t <= T; t++){
        A.clear();
        scanf("%d", &N);
        for(int i = 0; i < N; i++){
            scanf("%d", &input);
            A.push_back(input);
        }
        sort(A.begin(), A.end());

        scanf("%d", &M);
        for(int i = 0; i < M; i++){
            scanf("%d", &input);
            if(binarySearch(input))
                printf("1\n");
            else
                printf("0\n");
        }
    }
    return 0;
}