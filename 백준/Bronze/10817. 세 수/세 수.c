#include <stdio.h>

int main()
{
	int nums[3], tmp;
	scanf("%d %d %d", &nums[0], &nums[1], &nums[2]);
	for (int i = 0; i < 2; i++)
	{
		if (nums[i] > nums[i + 1])
		{
			tmp = nums[i];
			nums[i] = nums[i + 1];
			nums[i + 1] = tmp;
		}
	}
	if (nums[0] > nums[1])
		printf("%d", nums[0]);
	else
		printf("%d", nums[1]);
	return 0;
}
