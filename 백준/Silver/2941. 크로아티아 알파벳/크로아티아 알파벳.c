#include <stdio.h>
int main()
{
	char data[101] = { 0, }, i = 0, cnt = 0, temp;
	scanf("%s", data);
	while (data[i])
	{
		temp = data[i - 1];
		if (data[i] == '-' && (temp == 'c' || temp == 'd'))
				cnt--;
		else if (data[i] == 'j' && (temp == 'l' || temp == 'n'))
				cnt--;
		else if (data[i] == '=' && (temp == 'c' || temp == 's' || temp == 'z'))
		{
			cnt--;
			if (temp == 'z' && i > 1 && data[i - 2] == 'd')
				cnt--;
		}
		i++;
	}
	cnt = i + cnt;
	printf("%d", cnt);
	return 0;
}