#include <cstdio>

int find(int a);
void join(int a, int b);

int A[1000001];
int main()
{
	int n, m;
	int a, b, c;
	scanf("%d %d", &n, &m);

	for (int i = 0; i <= n; i++)
		A[i] = i;

	for (int i = 0; i < m; i++)
	{
		scanf("%d %d %d", &c, &a, &b);
		if (c == 0)
		{
			join(a, b);
		}
		else if (c == 1)
		{
			a = find(a);
			b = find(b);
			if (a == b)
				printf("YES\n");
			else
				printf("NO\n");
		}
	}
	return 0;
}

int find(int a)
{
	if (A[a] == a)
		return a;
	return A[a] = find(A[a]);
}

void join(int a, int b)
{
	int setA, setB;
	setA = find(a);
	setB = find(b);
	A[setB] = setA;
}