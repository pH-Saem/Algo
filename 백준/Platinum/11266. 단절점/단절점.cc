#include <cstdio>
#include <vector>

int V, E;
std::vector<int> AL[100001];

int VisitOrder[100001], order;
int CutVertex[100001];
int Ans[100000], c_Ans;

int dfs(int curr, int parent);

int main()
{
	scanf("%d %d", &V, &E);

	int A, B;
	for (int i = 0; i < E; i++)
	{
		scanf("%d %d", &A, &B);
		AL[A].push_back(B);
		AL[B].push_back(A);
	}

	for (int i = 1; i <= V; i++)
	{
		order = 0;
		if (VisitOrder[i] == 0)
			dfs(i, 0);
	}

	for (int i = 0; i <= V; i++)
		if (CutVertex[i])
			Ans[c_Ans++] = i;
	printf("%d\n", c_Ans);
	for (int i = 0; i < c_Ans; i++)
		printf("%d ", Ans[i]);
	printf("\n");

	return 0;
}

int dfs(int curr, int parent)
{
	VisitOrder[curr] = ++order;
	int minOrder = VisitOrder[curr];
	int child = 0;
	for (int next : AL[curr])
	{
		if (next == parent)
			continue;
		if (VisitOrder[next] > 0)
		{
			minOrder = VisitOrder[next] < minOrder ? VisitOrder[next] : minOrder;
		}
		else
		{
			++child;
			int low = dfs(next, curr);

			if (parent != 0 && VisitOrder[curr] <= low)
				CutVertex[curr] = 1;

			minOrder = low < minOrder ? low : minOrder;
		}
	}

	if (parent == 0 && child >= 2)
		CutVertex[curr] = 1;

	return minOrder;
}