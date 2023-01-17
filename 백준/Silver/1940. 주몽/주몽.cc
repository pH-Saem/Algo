#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int N, M, s, e, sum, cnt;

int main(){
    scanf("%d %d", &N, &M);
    vector<int> V(N);
    for(int i = 0; i < N; i++){
        scanf("%d", &V[i]);
    }
    sort(V.begin(), V.end());

    e = N-1;
    for(s = 0; s < N; s++){
        sum = V[s] + V[e];
        while(s < e && sum > M){
            e--;
            sum = V[s] + V[e];
        }
        if(e < 0 || s >= e)
            break;
        if(sum == M){
            cnt++;
            e--;
        }
    }
    printf("%d\n", cnt);
    return 0;
}