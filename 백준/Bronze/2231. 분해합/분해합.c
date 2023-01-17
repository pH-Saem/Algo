#include <stdio.h>

int creator(int N);

int main() {
	int N, ans;
	
	scanf("%d", &N);
	ans = creator(N);
	printf("%d", ans);

	return 0;
}

int creator(int N) {
	int ans = 0, cnt = 1, temp;
	while (cnt < N) {
		temp = cnt;
		ans = 0;
		for (int i = 0; i < 6; i++) {
			ans = ans + temp % 10;
			if (temp < 10)
				break;
			temp = temp / 10;
		}
		ans = ans + cnt;
		if (ans == N)
			break;
		cnt++;
	}
	if (cnt == N)
		cnt = 0;
	return cnt;
}