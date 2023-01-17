#include <stdio.h>

int main()
{
	int a;
	int ans = 0;
	scanf("%d", &a);
	for (int i = 1; i < a + 1; i++)
		ans = ans + i;
	printf("%d", ans);
	return 0;
}