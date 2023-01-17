#include <cstdio>

int C, R, K, cnt, c, r, dir;
int dx[4] = {0, 1, 0, -1}, dy[4] = {1, 0, -1, 0};
int A[1001][1001];

int main(){
    scanf("%d %d %d", &C, &R, &K);
    if(K > C*R)
        printf("0\n");
    else{
        c = 1, r = 0;
        for(int i = 1; i <= K; i++){
            if(r+dy[dir] > R || c+dx[dir] > C || r+dy[dir] < 1 || c+dx[dir] < 1 ||  A[r+dy[dir]][c+dx[dir]] != 0)
                dir++;
            if(dir >= 4)
                dir %= 4;
            r = r + dy[dir];
            c = c + dx[dir];
            A[r][c] = i;
        }

        printf("%d %d\n", c, r);
    }


    return 0;
}