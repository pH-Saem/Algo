#include <cstdio>

int N, M, Answer;
int road[1000002];

void updateAnswer(int index);

int main(){
    scanf("%d %d", &N, &M);
    for(int i = 1; i <= N; i++){
        scanf("%d", &road[i]);
        if(road[i])
            updateAnswer(i);
    }

    int order;
    for(int i = 0; i < M; i++){
        scanf("%d", &order);
        if(order){
            scanf("%d", &order);
            if(road[order] == 0){
                road[order] = 1;
                updateAnswer(order);
            }
        }else{
            printf("%d\n", Answer);
        }
    }

    return 0;
}

void updateAnswer(int index){
    if(road[index-1] == 1 && road[index+1] == 1)
        Answer--;
    if(road[index-1] == 0 && road[index+1] == 0)
        Answer++;
}