#include <iostream>
#include <math.h>
using namespace std;
void mkList(int*, int);
void clrList(int*, int);
void cntList(int*, int, int);
int main()
{
	int M, N, * cklist;
	while(1)
	{
		cin >> N;
		if (N == 0)
			break;
		M = N + N;
		if (M % 2 == 0)
			M = M - 1;
		cklist = new int[M / 2];
		clrList(cklist, M / 2);
		mkList(cklist, M);
		cntList(cklist, N+1, M);
		delete[] cklist;
	}
	return 0;
}


void clrList(int* list, int length)
{
	for (int i = 0; i < length; i++)
		list[i] = 1;
}

void mkList(int* list, int max)
{
	int sqrtMi = (int)sqrt((double)max), strpo, step;
	sqrtMi = (sqrtMi - 3) / 2;
	max = max / 2;
	for (int i = 0; i <= sqrtMi; i++)
	{
		strpo = 2 * i * i + 6 * i + 3;
		step = i + i + 3;
		for (int j = strpo; j < max; j = j + step)
			list[j] = 0;
	}
}

void cntList(int* list, int min, int max)
{
	int cnt = 0, length = max / 2;
	if (min < 3)
	{
		if (max >= 1)
		{
			cnt++;
		}
		min = 3;
	}
	else if (min % 2 == 0)
		min++;
	min = (min - 3) / 2;
	for (int i = min; i < length; i++)
	{
		if (list[i])
		{
			cnt++;
		}
	}
	cout << cnt << endl;
}