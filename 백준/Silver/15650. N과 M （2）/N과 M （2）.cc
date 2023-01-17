#include <cstdio>
#include <vector>

using namespace std;

int N, M;

void printV(int m, int ind, vector<int> V);

int main(){
    scanf("%d %d", &N, &M);
    vector<int> V(M+1);
    printV(1, 1, V);
    return 0;
}

void printV(int m, int ind, vector<int> V){
    for(int i = ind; i <= N; i++){
        V[m] = i;

        if(m == M){
            for(int j = 1; j <= M; j++)
                printf("%d ", V[j]);
            printf("\n");
        } else{
            printV(m+1, i+1, V);
        }

    }
}