#include <cstdio>
#include <queue>

struct tomato{
    int y;
    int x;
};

int N, M;
int box[1000][1000];
int day;
std::queue<tomato> q;

int main(){
    scanf("%d %d", &M, &N);
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            scanf("%d", &box[i][j]);
            if(box[i][j] == 1)
                q.push({i, j});
        }
    }

    q.push({-1, -1});

    tomato curr;
    int x, y;
    while(!q.empty()){
        curr = q.front();
        x = curr.x;
        y = curr.y;
        q.pop();

        if(x == -1 && y == -1){
            if(q.empty())
                break;
            day++;
            q.push(curr);
            continue;
        }else{
            if(x+1 < M && box[y][x+1] == 0){
                box[y][x+1] = 1;
                q.push({y, x+1});
            }
            if(x-1 >= 0 && box[y][x-1] == 0){
                box[y][x-1] = 1;
                q.push({y, x-1});
            }
            if(y+1 < N && box[y+1][x] == 0){
                box[y+1][x] = 1;
                q.push({y+1, x});
            }
            if(y-1 >= 0 && box[y-1][x] == 0){
                box[y-1][x] = 1;
                q.push({y-1, x});
            }
        }
    }

    // 안 익은 토마토 있는지 확인
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            if(box[i][j] == 0){
                day = -1;
                break;
            }
        }
    }

    printf("%d\n", day);

    return 0;
}