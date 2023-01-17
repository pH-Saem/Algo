#include <cstdio>
#include <vector>

using namespace std;

int N;

int main(){
    scanf("%d", &N);
    vector<int> V(N);

    for(int i = 0; i < N; i++){
        scanf("%d", &V[i]);
    }

    vector<int> D(N*2);
    D[0] = V[0];
    D[1] = V[0];
    D[2] = V[1] + D[0];
    D[3] = V[1];

    for(int i = 2; i < N; i++){
        D[i*2] = V[i] + D[(i-1)*2 + 1];
        D[i*2+1] = V[i] + (D[(i-2)*2] > D[(i-2)*2+1] ? D[(i-2)*2] : D[(i-2)*2+1]);
    }

    printf("%d\n", D[2*N-2] > D[2*N-1] ? D[2*N-2] : D[2*N-1]);

    return 0;
}