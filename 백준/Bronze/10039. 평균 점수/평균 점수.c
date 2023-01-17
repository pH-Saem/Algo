#include <stdio.h>

int main()
{
	int score, total = 0;
	for (int i = 0; i < 5; i++)
	{
		scanf("%d", &score);
		if (score < 40)
			total = 40 + total;
		else
			total = score + total;
	}
	printf("%d", total / 5);
	return 0;
}
