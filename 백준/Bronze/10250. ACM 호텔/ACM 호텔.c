#include <stdio.h>
int main()
{
	int T, H, W, N, col =0, row =0;
	scanf("%d", &T);
	for (int i = 0; i < T; i++)
	{
		scanf("%d %d %d", &H, &W, &N);
		row = N % H;
		col = N / H;
		if (row == 0)
			row = H;
		else
			col++;
		printf("%d%02d\n", row, col);

	}
	return 0;
}