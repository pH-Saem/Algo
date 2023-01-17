#include <stdio.h>
int main()
{
	int N, cnt = 1, size = 1;
	scanf("%d", &N);
	while (size < N)
		size = size + 6 * cnt++;
	printf("%d", cnt);
	return 0;
}