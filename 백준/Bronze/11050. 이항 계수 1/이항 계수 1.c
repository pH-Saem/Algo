#include <stdio.h>
double nCr(int, int);

int main()
{
    int N, K;
    scanf("%d %d", &N, &K);
    printf("%.lf\n", nCr(N, K));

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