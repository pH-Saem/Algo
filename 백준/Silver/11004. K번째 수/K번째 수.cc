#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int N, K;

int main(){
    scanf("%d %d", &N, &K);
    vector<int> V(N);
    for(int i = 0; i < N; i++){
        scanf("%d", &V[i]);
    }
    sort(V.begin(), V.end());
    printf("%d\n", V[K-1]);

    return 0;
}