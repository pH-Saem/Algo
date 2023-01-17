#include <cstdio>

int n, m;
int D[1001][1001];

int main(){
    scanf("%d %d", &n, &m);
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            scanf("%1d", &D[i][j]);
        }
    }

    int min, max = 0;
    int a, b, c;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if(D[i][j] == 1){
                a = D[i-1][j];
                b = D[i][j-1];
                c = D[i-1][j-1];
                if(a && b && c){
                    min = a < b ? a : b;
                    min = min < c ? min : c;         
                    D[i][j] += min;
                }
                if(max < D[i][j])
                    max = D[i][j];
            }
        }
    }

    printf("%d\n", max*max);
    
    return 0;
}