#include <stdio.h>

int main()
{
	int num;
	scanf("%d", &num);
	for (int i = 1; i <= 2 * num - 1; i++)
	{
		if (i <= num)
		{
			for (int m = 0; m < i - 1; m++)
				printf(" ");
			for (int j = 0; j < 2*num +1 -2*i; j++)
				printf("*");
		}
		else
		{
			for (int m = 0; m < 2 * num - 1 - i; m++)
				printf(" ");
			for (int j = 0; j < (-2)*num + 2*i + 1; j++)
				printf("*");
		}
		printf("\n");
	}
	return 0;
}
