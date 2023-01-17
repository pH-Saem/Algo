#include <stdio.h>

void reset_arr(char[], int);
int main()
{
	int t_case, score = 0;
	char data[81] = { 0, }, o_stack = 1, index = 0;
	scanf("%d", &t_case);
	for (int i = 0; i < t_case; i++)
	{
		scanf("%s", &data);
		while (1)
		{
			if (0 == data[index])
				break;
			else if ('O' == data[index])
				score = score + o_stack++;
			else if ('X' == data[index])
				o_stack = 1;
			index++;
		}
		printf("%d\n", score);
		score = 0;
		o_stack = 1;
		reset_arr(data, index);
		index = 0;
	}
	return 0;
}

void reset_arr(char data[], int length)
{
	for (int i = 0; i < length; i++)
		data[i] = 0;
}