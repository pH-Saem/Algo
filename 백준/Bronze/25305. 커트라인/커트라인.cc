#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> V;
int N, k, input;

int main(){
    scanf("%d %d", &N, &k);
    for(int i = 0; i < N; i++){
        scanf("%d", &input);
        V.push_back(input);
    }
    
    sort(V.begin(), V.end());

    printf("%d\n", V[N-k]);

    return 0;
}