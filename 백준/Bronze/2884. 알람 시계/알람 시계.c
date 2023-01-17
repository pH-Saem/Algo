#include <stdio.h>
int main()
{
	int a, b;
	scanf("%d %d", &a, &b);
	if (b >= 45)
		printf("%d %d", a, b - 45);
	else if (a == 0)
		printf("23 %d", b + 15);
	else
		printf("%d %d", a-1, b + 15);
	return 0;
}