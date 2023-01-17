#include <stdio.h>

int N, S, cnt = 0;

void part(int, int, int[]);

int main() {
	int input[20] = { 0, };

	scanf("%d %d", &N, &S);
	for (int i = 0; i < N; i++) {
		scanf("%d", &input[i]);
	}
	part(0, 0, input);
	if (S == 0)
		cnt = cnt - 1;
	printf("%d", cnt);
	return 0;
}

void part(int tot, int prev, int input[]) {

	for (int i = prev; i < N; i++) {
		part(tot + input[i], i+1 , input);
	}
	if (tot == S)
		cnt++;
}