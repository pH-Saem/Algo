#include <stdio.h>
#include <malloc.h>
void mk_dn(char*, int);
int main()
{
	char* p = (char *)malloc(sizeof(char) * 10000);
	for (int i = 0; i < 10000; i++)
		p[i] = 0;
	for (int i = 0; i < 10000; i++)
		mk_dn(p, i);
	for (int i = 0; i < 10000; i++)
		if (!p[i])
			printf("%d\n", i);

	free(p);
	return 0;
}

void mk_dn(char* p, int i)
{
	int dn = i;
	while (i)
	{
		dn = dn + i % 10;
		i = i / 10;
	}
	if(dn < 10000)
		p[dn] = 1;
}