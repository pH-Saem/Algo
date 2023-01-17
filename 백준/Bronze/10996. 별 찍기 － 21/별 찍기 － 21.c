#include <stdio.h>

int main()
{
	int num;
	scanf("%d", &num);
	for (int i = 0; i < 2*num; i++)
	{
		if (i % 2 == 0)
		{
			for (int j = 0; j < num; j++)
			{
				if (j % 2 == 0)
					printf("*");
				else
					printf(" ");
			}
		}
		else
		{
			for (int j = 0; j < num; j++)
			{
				if (j % 2 == 0)
					printf(" ");
				else
					printf("*");
			}
		}
		printf("\n");
	}
	return 0;
}
