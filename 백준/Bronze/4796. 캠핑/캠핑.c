#include <stdio.h>

int camping();

int main() {
	int cnt = 1, max;
	while (1) {
		max = camping();
		if (max < 0)
			break;
		printf("Case %d: %d\n", cnt, max);
		cnt++;
	}
	return 0;
}

int camping() {
	int L, P, V, temp;
	scanf("%d %d %d", &L, &P, &V);
	getchar();

	if (0 == L + P + V)
		return -1;
	temp = V % P;
	if (temp > L)
		temp = L;
		
	return (V / P) * L + temp;
}