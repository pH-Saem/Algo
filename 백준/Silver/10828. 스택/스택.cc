#include <cstdio>
#include <cstring>

int stack[10000];
int top = 0;

void push(int X);
int pop();
int size();
int empty();
int stmt_top();

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
		if (strcmp(stmt, "top") == 0)
		{
			printf("%d\n", stmt_top());
		}
	}

	return 0;
}

void push(int X)
{
	stack[top++] = X;
}

int pop()
{
	if (top == 0)
		return -1;
	return stack[--top];
}

int size()
{
	return top;
}

int empty()
{
	if (top == 0)
		return 1;
	return 0;
}

int stmt_top()
{
	if (top == 0)
		return -1;
	return stack[top - 1];
}