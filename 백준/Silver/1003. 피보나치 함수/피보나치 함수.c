#include <stdio.h>
#include <stdlib.h>

int ans[2] = { 0, }, fib[40][3] = { 0, };

int fibonacci(int n) 
{
    if (fib[n][0] != 0)
    {
        return fib[n][0];
    }
    else if (n == 0) 
    {
        fib[n][1] = 1;
        return 0;
    }
    else if (n == 1) 
    {
        fib[n][2] = 1;
        return 1;
    }
    else
    {
        fib[n][0] = fibonacci(n-1) + fibonacci(n-2);
        fib[n][1] = fib[n - 1][1] + fib[n - 2][1];
        fib[n][2] = fib[n - 1][2] + fib[n - 2][2];
        return fib[n][0];
    }
}

int main()
{
	int T, N;
	scanf("%d", &T);

	for (int i = 0; i < T; i++)
	{
		scanf("%d", &N);
        fibonacci(N);
        printf("%d %d\n", fib[N][1], fib[N][2]);
	}

	return 0;
}