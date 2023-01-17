#include <cstdio>

int N, M;
int board[50][50];
int count = 0;
int visited[50][50];
bool isCycle;

int move(int x, int y);

int main(){
    char input;
    scanf("%d %d", &N, &M);
    getchar();
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
            scanf("%c", &input);
            if(input == 'H')
                board[i][j] = -1;
            else
                board[i][j] = (int)input - 48;
            visited[i][j] = -1;
        }
        getchar();
    }
    isCycle = false;
    move(0, 0);

    if(isCycle)
        printf("-1\n");
    else{
        printf("%d\n", visited[0][0]);
    }
    return 0;
}

int move(int x, int y){
    if(x < 0 || y < 0 || x >= M || y >= N || isCycle || board[y][x] == -1)
        return 1;
    
    if(visited[y][x] == 0){
        isCycle = true;
        return -1;
    }else if(visited[y][x] == -1){
        int step = board[y][x];
        int a, b, c, d;
        visited[y][x] = 0;

        a = move(x+step, y);
        b = move(x-step, y);
        c = move(x, y+step);
        d = move(x, y-step);

        a = a > b ? a : b;
        a = a > c ? a : c;
        a = a > d ? a : d;

        visited[y][x] = a;
    }
    return visited[y][x] + 1;
}

