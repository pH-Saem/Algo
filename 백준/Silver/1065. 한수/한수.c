#include <stdio.h>
int check(int);
int main()
{
	int N = 0, cnt = 0;
	scanf("%d", &N);
	for (int i = 1; i <= N; i++)
		if (check(i))
			cnt++;
	printf("%d", cnt);
	return 0;
}

int check(int num)
{
	if (num > 0 && num < 100)
		return 1;
	else if (num >= 100 && num < 1000)
	{
		int o = num / 100;
		int t = (num % 100) / 10;
		int th = num % 10;
		if (o - t == t - th)
			return 1;
		else
			return 0;
	}
	else
		return 0;

}