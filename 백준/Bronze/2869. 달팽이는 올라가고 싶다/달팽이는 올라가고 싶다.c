#include <stdio.h>
int main()
{
	int A, B, V, D;
	scanf("%d %d %d", &A, &B, &V);
	V = V - A;
	D = A - B;
	if (V % D)
		printf("%d", V / D + 2);
	else
		printf("%d", V / D + 1);
	return 0;
}