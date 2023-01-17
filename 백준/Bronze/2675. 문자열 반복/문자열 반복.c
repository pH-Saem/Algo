#include <stdio.h>
void arrclear(char[]);
int main()
{
	int T, R, j = 0;
	char S[21] = { 0, };
	scanf("%d", &T);
	for (int i = 0; i < T; i++)
	{
		scanf("%d %s", &R, &S);
		j = 0;
		while (S[j])
		{
			for (int m = 0; m < R; m++)
				printf("%c", S[j]);
			j++;
		}
		printf("\n");
		arrclear(S);
	}

	return 0;
}

void arrclear(char data[])
{
	int i = 0;
	while (data[i])
		data[i++] = 0;
}