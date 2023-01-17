#include <stdio.h>

int sum = 10, data[10];
void count();

int main() {
	int N;
	scanf("%d", &N);
	for (int i = 0; i < 10; i++)
		data[i] = 1;
	
	for (int i = 0; i < N; i++)
		count();

	printf("%d", sum);
	
	return 0;
}

void count() {
	int total = 1;
	for (int i = 1; i < 10; i++) {
		total += data[i];
		if (total > 10007)
			total = total % 10007;
		data[i] = total;
	}

	sum = total;
}