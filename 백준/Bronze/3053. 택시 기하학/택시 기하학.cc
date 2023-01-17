#include <stdio.h>
#define PI 3.14159265358979323846
int main()
{
	double R;
	scanf("%lf", &R);
	printf("%0.6lf\n%0.6lf", R * R * PI, 2 * R * R);
	return 0;
}