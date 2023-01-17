#include <stdio.h>

int main()
{
	int n;
	float a[1000] = { 0, }, max = 0, total = 0;
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
	{
		scanf("%f", &a[i]);
		if (a[i] > max)
			max = a[i];
	}
	for (int i = 0; i < n; i++)
		total = total + a[i] / max * 100;
	printf("%f", total / n);
	
	return 0;
}