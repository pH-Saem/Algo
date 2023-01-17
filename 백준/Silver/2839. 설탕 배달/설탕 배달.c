#include <stdio.h>
int main()
{
	int N, f_quo = 0, rem = 0, min = 0;
	scanf("%d", &N);
	f_quo = N / 5;
	rem = N % 5;
	for (int i = 0; i < 3; i++)
	{
		if(rem % 3)
			if (f_quo != 0)
			{
				f_quo--;
				rem = 5 + rem;
			}
	}
	if (rem%3 == 0)
		printf("%d", f_quo + rem / 3);
	else
		printf("-1");
	return 0;
}