#include <cstdio>

int T, n;
int x1, y1, x2, y2;
int A[50][3];
int Answer;
bool s, e;

bool isInCircle(int index, int x, int y);

int main(){
    scanf("%d", &T);
    for(int i = 0; i < T; i++){
        Answer = 0;

        scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
        scanf("%d", &n);
        for(int j = 0; j < n; j++){
            scanf("%d %d %d", &A[j][0], &A[j][1], &A[j][2]);
        }

        for(int j = 0; j < n; j++){
            s = isInCircle(j, x1, y1);
            e = isInCircle(j, x2, y2);
            // 시작점이 행성계 내부에 있는 경우
            if(s){
                Answer++;
            }
            // 도착점이 행성계 내부에 있는 경우
            if(e){
                Answer++;
            }
            // 둘 다 해당하는 경우
            if(s && e){
                Answer -= 2;
            }
        }
        printf("%d\n", Answer);
    }
    return 0;
}

bool isInCircle(int index, int x, int y){
    int d;
    d = (x - A[index][0])*(x - A[index][0]) + (y - A[index][1])*(y - A[index][1]);
    if(d > A[index][2]*A[index][2])
        return false;
    else
        return true;
}