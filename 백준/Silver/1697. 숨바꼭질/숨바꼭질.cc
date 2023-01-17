#include <cstdio>
#include <queue>

using namespace std;

struct M{
    int position;
    int time;
};

int N, K, A[200001];
bool isFound;
queue<M> q;

void hideNSeek(M m);
bool check(int t1, int t2);

int main(){
    scanf("%d %d", &N, &K);
    if(N >= K)
        printf("%d\n", N-K);
    else{
        q.push({2*N, 1});
        q.push({N+1, 1});
        if(N > 0)
            q.push({N-1, 1});
        isFound = false;
        while(!q.empty()){
            if(isFound)
                break;
            hideNSeek(q.front());
            q.pop();
        }
        printf("%d\n", A[K]);
    }
    return 0;
}

void hideNSeek(M m){
    if(A[m.position] != 0 || m.position != N){
        A[m.position] = m.time;
        if(m.position == K)
            isFound = true;

        if(m.position < K && check(A[2*m.position], m.time+1))
            q.push({2*m.position, m.time+1});
        if(m.position < K && check(A[m.position+1], m.time+1))
            q.push({m.position+1, m.time+1});
        if(m.position > 0 && check(A[m.position-1], m.time+1))
            q.push({m.position-1, m.time+1});
    }
}

bool check(int t1, int t2){
    if(t1 > t2 || t1 == 0)
        return true;
    return false;
}