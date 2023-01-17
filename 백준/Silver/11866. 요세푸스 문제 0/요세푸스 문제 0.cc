#include <cstdio>
#include <vector>

using namespace std;

int N, K;

int main(){
    scanf("%d %d", &N, &K);

    vector<int> circle(N);
    for(int i = 0; i < N; i++)
        circle[i] = i+1;
    
    printf("<");
    int ind = 0;
    K -= 1;
    while(circle.size() != 1){
        ind += K;
        while(ind >= circle.size())
            ind = ind - circle.size();
        printf("%d, ", circle[ind]);
        circle.erase(circle.begin() + ind);
        if(ind == circle.size())
            ind = 0;
    }
    printf("%d>", circle[0]);

    return 0;
}