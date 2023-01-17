#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int N, answer, candidate, input;
vector<int> ropes(N);

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &input);
        ropes.push_back(input);
    }

    sort(ropes.begin(), ropes.end());
    answer = ropes[N-1];

    for(int i = 0; i < N; i++){
        if(ropes[i] <= (N-i)*ropes[i] && answer < (N-i)*ropes[i])
            answer = (N-i)*ropes[i];
    }
    printf("%d\n", answer);


    return 0;
}