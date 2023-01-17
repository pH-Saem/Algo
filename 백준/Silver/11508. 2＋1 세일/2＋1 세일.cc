#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int N, ans, cnt;

int main(){
    scanf("%d", &N);
    vector<int> V(N);
    for(int i = 0; i < N; i++){
        scanf("%d", &V[i]);
    }
    sort(V.begin(), V.end());
    for(int i = N-1; i >= 0; i--){
        if(cnt == 2){
            cnt = 0;
            continue;
        }
        ans += V[i];
        cnt++;
    }
    printf("%d\n", ans);

    return 0;
}