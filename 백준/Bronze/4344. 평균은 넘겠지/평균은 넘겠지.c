#include <stdio.h>
void reset_arr(int[], double);
int main()
{
	int tt_case, data[1000] = { 0, };
	double total, t_case, avg;
	scanf("%d", &tt_case);
	for (int i = 0; i < tt_case; i++)
	{
		total = 0;
		scanf("%lf", &t_case);
		for (int j = 0; j < t_case; j++)
		{
			scanf("%d", &data[j]);
			total = total + data[j];
		}
		avg = total / t_case;
		total = 0;
		for (int j = 0; j < t_case; j++)
			if (data[j] > avg)
				total = 1 + total;
		printf("%.3lf%%\n", total / t_case * 100);
		reset_arr(data, t_case);
	}
	return 0;
}

void reset_arr(int data[], double length)
{
	for (int i = 0; i < length; i++)
		data[i] = 0;
}