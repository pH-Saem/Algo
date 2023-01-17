#include <stdio.h>
#include <malloc.h>

int main()
{
    int N, M, i, j, temp, index, x1, x2, y1, y2;
    int *table;

    scanf("%d %d", &N, &M);
    N++;
    table = (int*)calloc(N*N, sizeof(int));
    
    // 입력받고 누적합 구해서 저장
    for(i = 1; i < N; i++)
    {
        for(j = 1; j < N; j++)
        {
            scanf("%d", &temp);
            index = i*N + j;
            table[index] = table[index - 1] + table[index - N] -table[index - N - 1] + temp;
        }
    }

    // 합을 구해야하는 범위 저장
    for(i = 0; i < M; i++)
    {
        scanf("%d %d %d %d", &x1, &y1, &x2, &y2);
        x1--;
        y1--;
        temp = table[x2*N + y2] - table[x1*N + y2] - table[x2*N + y1] + table[x1*N + y1];
        printf("%d\n", temp);
    }

    free(table);

    return 0;
}