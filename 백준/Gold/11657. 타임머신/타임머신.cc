#include <cstdio>
#include <vector>
#include <climits>

int N, M;
int A, B, C;
long long P[501];

bool isNegativeCycle = false;

struct edge
{
	int start;
	int end;
	int weight;
};
edge EL[6000];

int main()
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < M; i++)
	{
		scanf("%d %d %d", &A, &B, &C);
		EL[i] = {A, B, C};
	}

	P[1] = 0;
	for (int i = 2; i <= N; i++)
		P[i] = LONG_MAX;

	for (int i = 1; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			edge curr = EL[j];
			if (P[curr.start] == LONG_MAX)
				continue;
			if (P[curr.start] + curr.weight < P[curr.end])
				P[curr.end] = P[curr.start] + curr.weight;
		}
	}

	for (int i = 0; i < M; i++)
	{
		edge curr = EL[i];
		if (P[curr.start] == LONG_MAX)
			continue;
		if (P[curr.start] + curr.weight < P[curr.end])
		{
			isNegativeCycle = true;
			break;
		}
	}

	if (isNegativeCycle && N != 1)
		printf("-1\n");
	else
	{
		for (int i = 2; i <= N; i++)
		{
			if (P[i] == LONG_MAX)
				printf("-1\n");
			else
				printf("%lld\n", P[i]);
		}
	}

	return 0;
}