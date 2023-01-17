#include <stdio.h>
int main()
{
	char a = 0, ch = 0;
    int cnt = 0;
	a = getchar();
	while (a != '\n')
	{
		ch = getchar();
		if (ch == ' ' || ch == '\n')
			if (a != ' ')
				cnt++;
		a = ch;
	}
	printf("%d", cnt);
	return 0;
}