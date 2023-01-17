#include <stdio.h>
int main()
{
	int X, under = 1, top = 1, odd = 1;
	scanf("%d", &X);
	for (int i = 0; i < X - 1; i++)
	{
		if (odd)
		{
			if (top == 1)
			{
				under++;
				odd = 0;
			}
			else
			{
				top--;
				under++;
			}
		}
		else
			if (under == 1)
			{
				top++;
				odd = 1;
			}
			else
			{
				top++;
				under--;
			}
	}
	printf("%d/%d", top, under);
	return 0;
}