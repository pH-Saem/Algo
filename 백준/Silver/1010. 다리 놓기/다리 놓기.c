#include <stdio.h>

double nCr(int, int);

int main()
{
    int T, M, N;
    scanf("%d", &T);

    for (int i = 0; i < T; i++)
    {
        scanf("%d %d", &N, &M);
        printf("%.lf\n", nCr(M, N));
    }

    return 0;
}

double nCr(int n, int r)
{
    double result = 1, temp = 1;
    for (int i = r + 1; i <= n; i++)
        result = result * i;
    for (int i = 1; i <= n - r; i++)
        temp = temp * i;
    return result / temp;
}