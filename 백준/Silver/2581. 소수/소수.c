// 소수 구하기
#include <stdio.h>
#include <malloc.h>

int main()
{
    int M, N, *arr, min = 0, sum = 0;
    scanf("%d %d", &M, &N);

    arr = (int*)calloc(N+1 ,sizeof(int));

    for(int i = 2; i <= N; i++)
    {
        if(arr[i] == 0)
        {
            arr[i] = 1;

            int j = 2;
            while(1)
            {
                if(j*i > N)
                    break;
                arr[i*j] = -1;
                j++;
            }
        }
    }

    for(int i = M; i <= N; i++)
    {
        if(arr[i] == 1)
        {
            if(min == 0)
                min = i;
            sum += i;
        }
    }

    if(sum == 0)
        printf("%d\n", -1);
    else
        printf("%d\n%d", sum, min);

    return 0;
}