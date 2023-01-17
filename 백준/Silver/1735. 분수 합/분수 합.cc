#include <cstdio>

int gcd(int a, int b);

int main()
{
	int A, B, C, D, G;
	scanf("%d %d", &A, &B);
	scanf("%d %d", &C, &D);

	A = A * D + C * B;
	B = B * D;

	if (A > B)
		G = gcd(A, B);
	else
		G = gcd(B, A);

	printf("%d %d", A / G, B / G);

	return 0;
}

int gcd(int a, int b)
{
	if (b == 0)
		return a;
	int m = a % b;
	return gcd(b, m);
}