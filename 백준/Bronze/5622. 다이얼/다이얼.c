#include <stdio.h>
int time(char);
int main()
{
	char input[16] = { 0, }, cnt = 0;
	int tot = 0;
	scanf("%s", input);
	while (input[cnt])
		tot = tot + time(input[cnt++]);
	printf("%d", tot);
	return 0;
}

int time(char data)
{
	int t = 2;
	if (data >= 'A' && data <= 'C')
		return t + 1;
	else if (data >= 'D' && data <= 'F')
		return t + 2;
	else if (data >= 'G' && data <= 'I')
		return t + 3;
	else if (data >= 'J' && data <= 'L')
		return t + 4;
	else if (data >= 'M' && data <= 'O')
		return t + 5;
	else if (data >= 'P' && data <= 'S')
		return t + 6;
	else if (data >= 'T' && data <= 'V')
		return t + 7;
	else if (data >= 'W' && data <= 'Z')
		return t + 8;
	else
		return 0;
}