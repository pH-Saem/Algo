#include <stdio.h>

char visited[101] = {0,};
char lines[101][101] = {0,};

void DFS(int, int);

int main()
{
    int N, v, n1, n2, cnt = 0;

    scanf("%d %d", &N, &v);
    
    // 간선 정보 저장
    for(int i = 1; i <= v; i++)
    {
        scanf("%d %d", &n1, &n2);
        lines[n1][n2] = 1;
        lines[n2][n1] = 1;
    }

    // 깊이 우선 탐색
    DFS(1, N);

    // 방문한 정점 개수 - 자기 자신 출력
    for(int i = 1; i <= N; i++)
        if(visited[i] == 1)
            cnt++;

    printf("%d\n", cnt-1);

    return 0;
}

void DFS(int index, int N)
{
    visited[index] = 1;
    for(int i = 1; i <= N; i++)
    {
        if(lines[index][i] == 1)
            if(visited[i] == 0)
                DFS(i, N);
    }
}