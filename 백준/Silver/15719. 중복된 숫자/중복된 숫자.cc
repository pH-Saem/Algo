#include <cstdio>

int main() {
	int N, sum = 0, total = 0;

	scanf("%d", &N);

	int num = 0;
	for (int i = 0; i < N; i++) {
		scanf("%d", &num);
		sum += num;
		total += i;
	}

	printf("%d\n", sum - total);

	return 0;
}