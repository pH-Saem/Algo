#include <cstdio>
#include <vector>
#include <algorithm>

using namespace std;

struct p{
    int x;
    int y;
};

int N, x, y;
vector<p> A;

bool compare(p a, p b){
    if(a.y < b.y)
        return true;
    else if(a.y > b.y)
        return false;
    else
       return a.x < b.x;
}

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d %d", &x, &y);
        A.push_back({x, y});
    }

    sort(A.begin(), A.end(), compare);

    for(auto i : A)
        printf("%d %d\n", i.x, i.y);


    return 0;
}