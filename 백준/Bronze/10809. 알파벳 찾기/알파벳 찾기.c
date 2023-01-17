#include <stdio.h>

int main()
{
	char S[101] = { 0, };
	int alp[26] = { 0, }, ind = 0;
	scanf("%s", S);
	for (int i = 0; i < 26; i++)
		alp[i] = -1;
	while (S[ind])
	{
		for (int i = 0; i < 26; i++)
			if (S[ind] == 'a' + i)
			{
				if (alp[i] != -1)
					break;
				alp[i] = ind;

			}
		ind++;
	}
	for (int i = 0; i < 26; i++)
		printf("%d ", alp[i]);

	return 0;
}