// 소수 구하기
#include <stdio.h>

int main()
{
    int M, N;
    char arr[1000001] = {0,};
    scanf("%d %d", &M, &N);

    arr[0] = -1;
    arr[1] = -1;
    // 0부터 N까지의 수에서 소수를 찾아내는 부분
    // 2부터 N 중에서 처음 나온 애들의 배수는 -1
    for (int i = 2; i <= N; i++)
    {
        if(arr[i] == -1)
            continue;
        for(int j = 2; j*i <= N; j++)
            arr[i * j] = -1;
    }

    // 오름차순으로 소수 출력
    for (int i = M; i <= N; i++)
        if (arr[i] == 0)
            printf("%d\n", i);

    return 0;
}