#include <stdio.h>
void arr_clr(char*);
int ck_group(char*);
int main()
{
	char N, data[101] = { 0, }, cnt = 0;
	scanf("%hhd", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%s", data);
		if (ck_group(data))
			cnt++;
		arr_clr(data);
	}
	printf("%d", cnt);
	return 0;
}

void arr_clr(char* data)
{
	int i = 0;
	while (data[i])
		data[i++] = 0;
}

int ck_group(char* data)
{
	int i = 1;
	char pa = data[0], alp[26] = { 0, }, pr = 0;
	alp[pa - 'a'] = 1;
	while (data[i])
	{
		pr = data[i];
		if (pr == pa);
		else if (alp[pr - 'a'])
			return 0;
		else
			alp[pr - 'a'] = 1;
		pa = data[i];
		i++;
	}
	return 1;
}