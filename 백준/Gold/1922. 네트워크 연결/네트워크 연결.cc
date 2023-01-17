#include <cstdio>
#include <algorithm>

using namespace std;

typedef struct _edge
{
	int a;
	int b;
	int w;
} edge;

int N, M;
int V[1001];
edge E[100000];

bool compare(const edge &a, const edge &b);
int find(int a);
int main()
{
	scanf("%d %d", &N, &M);
	for (int i = 0; i < M; i++)
		scanf("%d %d %d", &E[i].a, &E[i].b, &E[i].w);
	for (int i = 1; i <= N; i++)
		V[i] = i;

	sort(E, E + M, compare);

	int count = 0, weight = 0, p = 0;
	int setA, setB;
	while (count != N - 1)
	{
		setA = find(E[p].a);
		setB = find(E[p].b);
		if (setA != setB)
		{
			weight += E[p].w;
			V[setB] = setA;
			count++;
		}
		p++;
	}

	printf("%d\n", weight);

	return 0;
}

bool compare(const edge &a, const edge &b)
{
	if (a.w < b.w)
		return true;
	return false;
}

int find(int a)
{
	if (V[a] == a)
		return a;
	return V[a] = find(V[a]);
}