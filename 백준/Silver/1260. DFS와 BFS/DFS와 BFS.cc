#include <cstdio>
#include <queue>

using namespace std;

int N, M, V;
int visited[1001];
std::priority_queue<int, vector<int>, greater<int>> Q[10001];
std::priority_queue<int, vector<int>, greater<int>> BQ[10001];


void dfs(int v);
void bfs(int v);

int main(){
    scanf("%d %d %d", &N, &M, &V);

    int a, b;
    for(int i = 1; i <= M; i++){
        scanf("%d %d", &a, &b);
        Q[a].push(b);
        Q[b].push(a);
        BQ[a].push(b);
        BQ[b].push(a);
    }

    dfs(V);
    for(int i = 0; i <= N; i++)
        visited[i] = 0;
    printf("\n");
    bfs(V);

    return 0;
}

// visited 0 : 미방문, 1 : 방문중, 2 : 방문완료
void dfs(int v){
    int next;
    if(visited[v] == 0){
        visited[v] = 1;
        printf("%d ", v);
        while(!Q[v].empty()){
            next = Q[v].top();
            Q[v].pop();
            if(visited[next] == 0)
                dfs(next);
        }
        visited[v] = 2;
    }
}

void bfs(int v){
    queue<int> q;
    int curr, next;

    q.push(v);
    visited[v] = 1;
    while(!q.empty()){
        curr = q.front();
        q.pop();
        printf("%d ", curr);

        while(!BQ[curr].empty()){
            next = BQ[curr].top();
            BQ[curr].pop();
            if(visited[next] == 0){
                q.push(next);
                visited[next] = 1;
            }
        }
        visited[curr] = 2;
    }
}