#include <iostream>
#include <math.h>
using namespace std;
int setData(int*, int);
void mkList(int*, int);
void clrList(int*, int);
int cntList(int*, int*, int);
int main()
{
	int T, *data, M, *cklist, ans;
	cin >> T;
	data = new int[T];
	M = setData(data, T);
	cklist = new int[M / 2];
	clrList(cklist, M / 2);
	mkList(cklist, M);
	ans = cntList(cklist, data, T);
	cout << ans;
	delete[] data;
	delete[] cklist;
	return 0;
}

int setData(int* data, int T)
{
	int max = 0;
	for (int i = 0; i < T; i++)
	{
		cin >> data[i];
		if (max < data[i])
			max = data[i];
	}
	if (max % 2 == 0)
		max--;
	return max;
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
		step = 2 * i + 3;
		for (int j = strpo; j < max; j = j+step)
			list[j] = 0;
	}
}

int cntList(int* list, int* data, int length)
{
	int cnt = 0, temp;
	for (int i = 0; i < length; i++)
	{
		temp = data[i];
		if (temp == 2)
			cnt++;
		else if (temp % 2 == 0 || temp == 1)
			continue;
		else
		{
			temp = (temp - 3) / 2;
			if (list[temp])
				cnt++;
		}
	}
	return cnt;
}