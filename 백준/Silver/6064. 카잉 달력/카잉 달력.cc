#include <cstdio>

int T, M, N, x, y;

int kaing();
int hojae(int A, int B);

int main(){
    int answer;

    scanf("%d", &T);
    for(int t = 0; t < T; t++){
        scanf("%d %d %d %d", &M, &N, &x, &y);
        answer = kaing();
        printf("%d\n", answer);
    }

    return 0;
}

int kaing(){
    int max_count;
    int S, s, B, b;

    if(x == y && x <= M && y <= N)
        return x;

    max_count = M * N / hojae(M, N);

    if(x == M && y == N)
        return max_count;

    if(M >= N){
        B = M; b = x; S = N; s = y;
    } else{
        B = N; b = y; S = M; s = x;
    }

    if(b - s == S)
        return b;

    if(b == B)
        b = 0;
    for(int i = S+s; i <= max_count; i = i+S){
        if(i%B == b)
            return i;
    }

    return -1;
}

int hojae(int A, int B){
    if(A%B == 0)
        return B;
    return hojae(B, A%B);
}