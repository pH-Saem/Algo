#include <stdio.h>

int main()
{
	int N, sum = 0;
	char num[101];
	scanf("%d %s", &N, num);
	for (int i = 0; i < N; i++)
		sum = sum + num[i] - '0';
	printf("%d", sum);

	return 0;
}