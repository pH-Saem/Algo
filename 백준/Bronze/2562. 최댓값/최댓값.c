#include <stdio.h>

int main()
{
	int max = 0, index = 0, data[9] = { 0, };
	for (int i = 0; i < 9; i++)
	{
		scanf("%d", &data[i]);
		if (max < data[i])
		{
			max = data[i];
			index = i;
		}
	}
	printf("%d\n%d", max, index+1);
	return 0;
}
