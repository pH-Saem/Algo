#include <cstdio>

int G[52][52];

int check(int y, int x);
void erase(int y, int x);

int main(){
    int T, M, N, K, answer;
    scanf("%d", &T);

    for(int t = 0; t < T; t++){
        scanf("%d %d %d", &M, &N, &K);
        answer = 0;

        for(int n = 1; n <= N; n++)
            for(int m = 1; m <= M; m++)
                G[n][m] = 0;
        
        int x, y;
        for(int k = 0; k < K; k++){
            scanf("%d %d", &x, &y);
            x++;
            y++;
            G[y][x] = 1;
        }

        for(int n = 1; n <= N; n++)
            for(int m = 1; m <= M; m++)
                answer += check(n, m);

        printf("%d\n", answer);
    }

    return 0;
}

int check(int y, int x){
    if(G[y][x] == 1){
        erase(y,x);
        return 1;
    }
    return 0;
}

void erase(int y, int x){
    G[y][x] = 0;
    if(G[y-1][x])
        erase(y-1, x);
    if(G[y+1][x])
        erase(y+1, x);
    if(G[y][x-1])
        erase(y, x-1);
    if(G[y][x+1])
        erase(y, x+1);
}