#include <cstdio>

int N, B, C;
int* room;

void init() {
	scanf("%d", &N);
	
	room = new int[N];
	for (int i = 0; i < N; i++) {
		scanf("%d", &room[i]);
	}

	scanf("%d %d", &B, &C);
}

void solution() {
	long totalCount = 0;

	for (int i = 0; i < N; i++) {
		room[i] -= B;
		totalCount++;

		if (room[i] > 0) {
			totalCount += room[i] / C;
			if (room[i] % C != 0)
				totalCount++;
		}
	}

	printf("%ld\n", totalCount);

	delete[] room;
}

int main() {
	init();
	solution();
	return 0;
}