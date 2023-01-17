#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

int K, N, input, largest_gap;
vector<int> score;

int main(){
    scanf("%d", &K);
    for(int i = 1; i <= K; i++){
        score.clear();
        scanf("%d", &N);
        for(int j = 0; j < N; j++){
            scanf("%d", &input);
            score.push_back(input);
        }

        sort(score.begin(), score.end());

        largest_gap = 0;
        for(int j = 0; j < N-1; j++){
            if(largest_gap < score[j+1] - score[j])
                largest_gap = score[j+1] - score[j];
        }

        printf("Class %d\n", i);
        printf("Max %d, Min %d, Largest gap %d\n", score.back(), score[0], largest_gap);
    }
    return 0;
}