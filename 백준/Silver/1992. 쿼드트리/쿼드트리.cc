#include <cstdio>
#include <vector>

void quadtree(int sy, int sx, int ey, int ex);

int N, input, A[65][65];

int main(){
    scanf("%d", &N);
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            scanf("%1d", &input);
            A[i][j] = input + A[i-1][j] + A[i][j-1] - A[i-1][j-1];
        }
    }

    quadtree(0, 0, N, N);

    return 0;
}

void quadtree(int sy, int sx, int ey, int ex){
    int sum = A[ey][ex] - A[ey][sx] - A[sy][ex] + A[sy][sx];
    if(sum == 0)
        printf("0");
    else if(sum == (ey - sy)*(ey - sy))
        printf("1");
    else{
        int len = (ey - sy)/2;
        printf("(");
        quadtree(sy, sx, sy+len, sx+len);
        quadtree(sy, sx+len, sy+len, ex);
        quadtree(sy+len, sx, ey, sx+len);
        quadtree(sy+len, sx+len, ey, ex);
        printf(")");
    }
}