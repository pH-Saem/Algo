#include <stdio.h>

int main()
{
	int tmp, result = 1, cnt = 0, each[20] = { 0, }, ans[10] = { 0, };
	for (int i = 0; i < 3; i++)
	{
		scanf("%d", &tmp);
		result = result * tmp;
	}
	while (result)
	{
		each[cnt++] = result % 10;
		result = result / 10;
	}
	for (int i = 0; i < cnt; i++)
	{
		ans[each[i]]++;
	}
	for (int i = 0; i < 10; i++)
		printf("%d\n", ans[i]);
	
	return 0;
}