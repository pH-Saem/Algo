#include <stdio.h>

int main()
{
	int mc, drk, tmp = 3000;
	for (int i = 0; i < 3; i++)
	{
		scanf("%d", &mc);
		if (mc < tmp)
			tmp = mc;
	}
	mc = tmp;
	tmp = 3000;
	for (int i = 0; i < 2; i++)
	{
		scanf("%d", &drk);
		if (drk < tmp)
			tmp = drk;
	}
	printf("%d", mc + tmp - 50);
	
	return 0;
}
