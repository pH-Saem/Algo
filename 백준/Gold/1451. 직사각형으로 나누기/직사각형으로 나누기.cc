#include <cstdio>

int N, M;
int A[51][51];
int sum[51][51];
long long Answer;

int main(){
    scanf("%d %d", &N, &M);
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= M; j++){
            scanf("%1d", &A[i][j]);
            sum[i][j] = A[i][j] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
        }
    }

    long long a, b, c;
    for(int y = 1; y <= N; y++){
        for(int x = 1; x <= M; x++){
            // Case 1 : x가 M인 경우
            if(x == M){
                a = sum[y][x];
                // 세로로 자르는 경우
                for(int i = 1; i < M; i++){
                    b = sum[N][i] - sum[y][i];
                    c = sum[N][M] - a - b;
                    if(Answer < a*b*c)
                        Answer = a*b*c;
                }
                // 가로로 자르는 경우
                for(int i = y+1; i < N; i++){
                    b = sum[i][M] - a;
                    c = sum[N][M] - a - b;
                    if(Answer < a*b*c)
                        Answer = a*b*c;
                }
            }
            // Case 2 : y가 N인 경우
            else if(y == N){
                a = sum[y][x];
                // 가로로 자르는 경우
                for(int i = 1; i < N; i++){
                    b = sum[i][M] - sum[i][x];
                    c = sum[N][M] - a - b;
                    if(Answer < a*b*c)
                        Answer = a*b*c;
                }
                // 세로로 자르는 경우
                for(int i = x+1; i < M; i++){
                    b = sum[N][i] - a;
                    c = sum[N][M] - a - b;
                    if(Answer < a*b*c)
                        Answer = a*b*c;
                }
            }
            // Case 3 : 그 외의 경우
            else{
                a = sum[y][x];
                b = sum[y][M] - a;
                c = sum[N][M] - sum[y][M];
                if(Answer < a*b*c)
                    Answer = a*b*c;
                b = sum[N][x] - a;
                c = sum[N][M] - sum[N][x];
                if(Answer < a*b*c)
                    Answer = a*b*c;
            }
        }
    }

    printf("%lld\n", Answer);

    return 0;
}