#include <stdio.h>
int rev_num(int);
int main()
{
	int A, B;
	scanf("%d %d", &A, &B);
	A = rev_num(A);
	B = rev_num(B);
	if (A > B)
		printf("%d", A);
	else
		printf("%d", B);
	return 0;
}

int rev_num(int num)
{
	int h, t, o;
	h = num / 100;
	t = (num/10)%10;
	o = num % 10;
	num = o * 100 + t * 10 + h;
	return num;
}