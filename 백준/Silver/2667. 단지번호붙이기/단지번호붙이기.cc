#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

int N, houses[27][27];
vector<int> group;

int check(int x, int y);

int main(){
    scanf("%d", &N);

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            scanf("%1d", &houses[i][j]);
        }
    }

    int cnt;
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cnt = check(j, i);
            if(cnt)
                group.push_back(cnt);
        }
    }

    sort(group.begin(), group.end());

    printf("%d\n", group.size());
    for(auto g : group)
        printf("%d\n", g);

    return 0;
}

int check(int x, int y){
    if(houses[y][x] == 1){
        houses[y][x] = group.size()+2;
        return 1 + check(x+1, y) + check(x-1, y) + check(x, y+1) + check(x, y-1);
    } else
        return 0;
}