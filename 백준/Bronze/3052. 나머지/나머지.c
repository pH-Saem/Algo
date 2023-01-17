#include <stdio.h>

int main()
{
	int tmp, per[10], cnt = 0, ck =1;
	for (int i = 0; i < 10; i++)
	{
		scanf("%d", &tmp);
		per[i] = tmp % 42;
	}
	for (int i = 0; i < 10; i++)
	{
		ck = 1;
		for (int j = 0; j < i; j++)
			if (per[i] == per[j])
				ck = 0;
		if (ck)
			cnt++;
	}
	printf("%d", cnt);
	
	return 0;
}