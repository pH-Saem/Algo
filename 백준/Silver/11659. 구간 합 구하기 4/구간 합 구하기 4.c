#include <stdio.h>
#include <malloc.h>

int main()
{
    int M, N, *list, i, n1, n2, sum = 0, temp;
    
    scanf("%d %d", &N, &M);

    list = (int*)malloc((N+1)*sizeof(N));
    list[0] = 0;

    for(i = 1; i <= N; i++)
    {
        scanf("%d", &temp);
        sum += temp;
        list[i] = sum;
    }

    for(i = 1; i <= M; i++)
    {
        scanf("%d %d", &n1, &n2);
        printf("%d\n", list[n2] - list[n1 - 1]);

    }

    free(list);

    return 0;
}