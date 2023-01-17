#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

struct cow{
    int arrive;
    int waiting;
};

bool compare(const cow& a, const cow& b){
    return a.arrive < b.arrive;
}

int N, a, w;
long long ans;

int main(){
    scanf("%d", &N);
    vector<cow> cows(N);
    for(int i = 0; i < N; i++){
        scanf("%d %d", &a, &w);
        cows[i] = {a, w};
    }
    sort(cows.begin(), cows.end(), compare);
    for(int i = 0; i < N; i++){
        if(ans < cows[i].arrive)
            ans = cows[i].arrive;
        ans += cows[i].waiting;
    }
    printf("%d\n", ans);
}