#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int N;
long long tips;

bool compare(const int a, const int b){
    return a > b;
}

int main(){
    scanf("%d", &N);
    vector<int> V(N);
    for(int i = 0; i < N; i++){
        scanf("%d", &V[i]);
    }
    sort(V.begin(), V.end(), compare);
    int tip;
    for(int i = 1; i <= N; i++){
        tip = V[i-1] + (1 - i);
        if(tip < 0)
            break;
        tips += tip;
    }
    printf("%lld\n", tips);

    return 0;
}