#include <stdio.h>
#include <malloc.h>

int N;

int main()
{
	scanf("%d", &N);
	int* people = (int*)malloc(sizeof(int) * 2 * N);
	int* ranks = (int*)malloc(sizeof(int) * N);
	int kg, height, rank;

	for (int i = 0; i < N; i++)
		scanf("%d %d", &people[i * 2], &people[i * 2 + 1]);
	
	for (int i = 0; i < N; i++)
	{
		rank = 1;
		kg = people[2 * i];
		height = people[2 * i + 1];
		for (int j = 0; j < N; j++)
		{
			if (j == i)
				continue;
			if ((kg < people[j * 2]) && (height < people[j * 2 + 1]))
				rank++;
		}
		ranks[i] = rank;
	}

	for (int i = 0; i < N; i++)
		printf("%d ", ranks[i]);

	return 0;
}