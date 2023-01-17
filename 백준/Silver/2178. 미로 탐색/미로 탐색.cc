#include <cstdio>

int N, M;
int maze[102][102], map[101][101];

void moveOneStep(int x, int y, int value);

int main(){
    scanf("%d %d", &N, &M);

    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= M; j++){
            scanf("%1d", &maze[i][j]);
        }
    }
    moveOneStep(1, 1, 1);

    printf("%d\n", map[N][M]);

    return 0;
}

void moveOneStep(int x, int y, int value){
    if(maze[y][x]){
        if(map[y][x] > value || map[y][x] == 0){
            map[y][x] = value;

            moveOneStep(x+1, y, value+1);
            moveOneStep(x-1, y, value+1);
            moveOneStep(x, y+1, value+1);
            moveOneStep(x, y-1, value+1);
        }
    }
}