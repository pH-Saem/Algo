#include <stdio.h>

int main()
{
	int N, ini, cnt = 0;
	scanf("%d", &N);
	ini = N;
	while (1)
	{
        if(N < 10)
        {
            N = N*10 + N;
            cnt++;
        }
        else
        {
		    N = N % 10 * 10 + (N / 10 + N % 10)%10;
		    cnt++;
        }
		if (ini == N)
			break;
	}	
	printf("%d", cnt);
	return 0;
}