#include <cstdio>
#include <vector>

using namespace std;

int N, M;
int D[101][101];

int main(){
    scanf("%d %d", &N, &M);

    for(int i = 0; i <= N; i++)
        for(int j = 0; j <= N; j++){
            if(i == j)
                D[i][j] = 0;
            else
                D[i][j] = 200;
        }

    int a, b;
    for(int i = 0; i < M; i++){
        scanf("%d %d", &a, &b);
        D[a][b] = 1;
        D[b][a] = 1;
    }

    for(int k = 1; k <= N; k++){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(D[i][j] > D[i][k] + D[k][j])
                    D[i][j] = D[i][k] + D[k][j];
            }
        }
    }

    int m = 100000, sum = 0, ind = 0;
    for(int i = 1; i <= N; i++){
        sum = 0;
        for(int j = 1; j <= N; j++)
            sum += D[i][j];
        if(sum < m){
            m = sum;
            ind = i;
        }
    }

    printf("%d\n", ind);

    return 0;
}