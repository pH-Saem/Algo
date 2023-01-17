#include <stdio.h>
int main()
{
	int a;
	scanf("%d", &a);
	if (a >= 90 && a <= 100)
		putchar('A');
	else if (a >= 80 && a <= 89)
		putchar('B');
	else if (a >= 70 && a <= 79)
		putchar('C');
	else if (a >= 60 && a <= 69)
		putchar('D');
	else
		putchar('F');
	return 0;
}