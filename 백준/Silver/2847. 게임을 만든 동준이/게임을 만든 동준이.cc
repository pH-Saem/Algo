#include <cstdio>

int N, levels[100], max_score, count;

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &levels[i]);
    }
    max_score = levels[N-1] - 1;
    for(int i = N-2; i >= 0; i--){
        if(levels[i] > max_score){
            count = count + (levels[i] - max_score);
            max_score--;
        } else{
            max_score = levels[i] - 1;
        }
    }
    printf("%d\n", count);

    return 0;
}