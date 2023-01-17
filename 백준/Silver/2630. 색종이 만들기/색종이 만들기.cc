#include <cstdio>

int N, blue_count, white_count, temp;
int A[129][129];

void check(int x, int y, int len);

int main(){
    scanf("%d", &N);
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            scanf("%d", &temp);
            A[i][j] = A[i-1][j] + A[i][j-1] - A[i-1][j-1] + temp;
        }
    }
    check(0, 0, N);

    printf("%d\n%d\n", white_count, blue_count);

    return 0;
}

void check(int x, int y, int len){
    int size = len * len;
    int x2 = x + len, y2 = y + len;
    int value = A[y2][x2] - A[y2][x] - A[y][x2] + A[y][x];

    if(value == 0)
        white_count++;
    else if(value == size)
        blue_count++;
    else{
        len = len>>1;
        check(x, y, len);
        check(x, y+len, len);
        check(x+len, y, len);
        check(x+len, y+len, len);
    }
}

