#include <cstdio>
#include <vector>
#include <algorithm>

int N, M;
int WB[50][50];
int total;
std::vector<int> V;

void makeTopLeftWBoard();
int getEightRowSum(int y, int x);
int getEightColSum(int y, int x);

int main(){
    scanf("%d %d", &N, &M);
    makeTopLeftWBoard();

    for(int i = 0; i < 8; i++)
        total += getEightRowSum(i, 0);

    int prevTotal;
    for(int i = 0; i <= N - 8; i++){
        prevTotal = total;
        for(int j = 0; j <= M - 8; j++){
            V.push_back(total);
            total = total - getEightColSum(i, j) + getEightColSum(i, j + 8);
        }
        total = prevTotal - getEightRowSum(i, 0) + getEightRowSum(i + 8, 0);
    }

    std::sort(V.begin(), V.end());
    int min = 64 - V.back();
    if(min > V.front())
        min = V.front();
    
    printf("%d\n", min);
    
    return 0;
}

void makeTopLeftWBoard(){
    char input;
    bool isW = true;
    bool isStartW = true;
    for(int i = 0; i < N; i++){
        getchar();
        for(int j = 0; j < M; j++){
            input = getchar();

            if(isW){
                if(input == 'B')
                    WB[i][j] = 1;
            }else{
                if(input == 'W')
                    WB[i][j] = 1;
            }
            isW = !isW;
        }
        if(isStartW){
            isW = false;
            isStartW = false;
        }else{
            isW = true;
            isStartW = true;
        }
    }
}

int getEightRowSum(int y, int x){
    int sum = 0;
    for(int i = 0; i < 8; i++)
        sum += WB[y][x + i];
    return sum;
}

int getEightColSum(int y, int x){
    int sum = 0;
    for(int i = 0; i < 8; i++)
        sum += WB[y + i][x];
    return sum;
}