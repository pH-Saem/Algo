#include <cstdio>
#include <algorithm>

struct point{
    int x;
    int y;
};

int N, x, y, ind;
point A[100000];

bool compareX(point a, point b){
    return a.x < b.x;
}

bool compareY(point a, point b){
    return a.y < b.y;
}

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d %d", &x, &y);
        A[i] = {x, y};
    }
    
    std::sort(A, A+N, compareX);
    
    ind = 0;
    for(int i = 0; i < N; i++){
        if(A[ind].x != A[i].x){
            std::sort(A+ind, A+i, compareY);
            ind = i;
        }
    }
    std::sort(A+ind, A+N, compareY);

    for(int i = 0; i < N; i++){
        printf("%d %d\n", A[i].x, A[i].y);
    }

    return 0;
}