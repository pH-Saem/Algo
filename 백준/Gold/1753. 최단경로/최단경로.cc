#include <cstdio>
#include <vector>
#include <queue>

const int INF = 2000000000;

int V, E;
int start;
// std::vector<std::pair<int, int>> AL[20001];
struct edge
{
	int node;
	int w;
	bool operator<(const edge &ref) const
	{
		return this->w > ref.w;
	}
};
std::vector<edge> AL[20001];

int visited[20001];

int main()
{
	scanf("%d %d", &V, &E);
	scanf("%d", &start);
	int a, b, c;
	for (int i = 0; i < E; i++)
	{
		scanf("%d %d %d", &a, &b, &c);
		AL[a].push_back({b, c});
	}

	for (int i = 1; i <= V; i++)
		visited[i] = INF;
	visited[start] = 0;

	std::priority_queue<edge> PQ; // w에 대한 Min Heap으로 해야함. -> w에 대한 대소비교를 해야하므로 operator 오버로딩 필요
	PQ.push({start, 0});
	while (!PQ.empty())
	{
		edge curr = PQ.top();
		PQ.pop();
		for (edge next : AL[curr.node])
		{
			int cost = curr.w + next.w;
			if (cost < visited[next.node])
			{
				visited[next.node] = cost;
				PQ.push({next.node, cost});
			}
		}
	}

	for (int i = 1; i <= V; i++)
	{
		if (visited[i] == INF)
			printf("INF\n");
		else
			printf("%d\n", visited[i]);
	}

	return 0;
}