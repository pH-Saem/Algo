#include<cstdio>
#include<vector>
#include<algorithm>

#define MAX_VALUE 1'000'000'000

using namespace std;

int V, E;
int** graph;

void init() {
	scanf("%d %d", &V, &E);

	graph = new int*[V];
	for (int i = 0; i < V; i++)
		graph[i] = new int[V];

	for (int i = 0; i < V; i++) {
		for (int j = 0; j < V; j++) {
			if (i == j)
				graph[i][j] = 0;
			else
				graph[i][j] = MAX_VALUE;
		}
	}

	int s, e, w;
	for (int i = 0; i < E; i++) {
		scanf("%d %d %d", &s, &e, &w);
		graph[s - 1][e - 1] = w;
	}
}

void solution() {
	for (int k = 0; k < V; k++) {
		for (int i = 0; i < V; i++) {
			for (int j = 0; j < V; j++) {
				graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j]);
			}
		}
	}

	int minDist = MAX_VALUE;
	for (int i = 0; i < V; i++) {
		for (int j = 0; j < V; j++) {
			if (i == j) continue;
			minDist = min(minDist, graph[i][j] + graph[j][i]);
		}
	}

	if (minDist == MAX_VALUE)
		minDist = -1;

	printf("%d\n", minDist);
}

int main() {
	init();
	solution();
	return 0;
}