#include <cstdio>
#include <algorithm>

int N, M;
int num[10];

void makeCombination(int nthChoice, int* selected, int startIdx) {
	if (nthChoice == M) {
		for (int i = 0; i < M; i++) {
			printf("%d ", selected[i]);
		}
		printf("\n");
		return;
	}

	for (int i = startIdx; i < N; i++) {
		selected[nthChoice] = num[i];
		makeCombination(nthChoice + 1, selected, i + 1);
	}
}

int main() {
	scanf("%d %d", &N, &M);
	
	for (int i = 0; i < N; i++) {
		scanf("%d", &num[i]);
	}

	std::sort(num, num + N);
	makeCombination(0, new int[M], 0);

	return 0;
}