#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int N, input;
vector<int> V;

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &input);
        V.push_back(input);
    }
    
    sort(V.begin(), V.end());

    for(auto v : V)
        printf("%d\n", v);

    return 0;
}