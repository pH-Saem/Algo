#include <cstdio>
#include <cstring>

int queue[20000];
int f = 0, e = 0;

void push(int x);
int pop();
int size();
int size();
int empty();
int front();
int back();

int main()
{
	int N, num;
	char stmt[10];

	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%s", stmt);
		if (strcmp(stmt, "push") == 0)
		{
			scanf("%d", &num);
			push(num);
		}
		if (strcmp(stmt, "pop") == 0)
		{
			printf("%d\n", pop());
		}
		if (strcmp(stmt, "size") == 0)
		{
			printf("%d\n", size());
		}
		if (strcmp(stmt, "empty") == 0)
		{
			printf("%d\n", empty());
		}
		if (strcmp(stmt, "front") == 0)
		{
			printf("%d\n", front());
		}
		if (strcmp(stmt, "back") == 0)
		{
			printf("%d\n", back());
		}
	}

	return 0;
}

void push(int x)
{
	queue[e++] = x;
}

int pop()
{
	if (f == e)
		return -1;
	return queue[f++];
}

int size()
{
	return e - f;
}

int empty()
{
	if (f == e)
		return 1;
	return 0;
}

int front()
{
	if (f == e)
		return -1;
	return queue[f];
}

int back()
{
	if (f == e)
		return -1;
	return queue[e - 1];
}