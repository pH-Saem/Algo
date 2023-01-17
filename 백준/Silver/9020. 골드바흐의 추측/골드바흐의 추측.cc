#include <iostream>
#include <math.h>
using namespace std;
void mkList(int*, int);
void clrList(int*, int);
void fdGold(int*, int);
int main()
{
	int M, T, * cklist;
	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> M;
		if (M == 4)
		{
			cout << 2 << " " << 2 << endl;
			continue;
		}
		if (M % 2 == 0)
			M = M - 1;
		cklist = new int[M / 2];
		clrList(cklist, M / 2);
		mkList(cklist, M);
		fdGold(cklist, M + 1);
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



void fdGold(int* list, int max)
{
	int ckRange = max / 4, ans[3] = { 0, }, temp, dif;
	for (int i = 0; i < ckRange; i++)
	{
		if (list[i])
		{
			temp = max - i - i - 3;
			temp = (temp - 3) / 2;
			if (temp < 0)
				continue;
			if (temp < i)
				dif = i - temp;
			else
				dif = temp - i;
			if (list[temp])
			{
				if (ans[2])
				{
					if (ans[2] > dif)
					{
						ans[0] = i;
						ans[1] = temp;
						ans[2] = dif;
					}
					
				}
				else
				{
					ans[0] = i;
					ans[1] = temp;
					ans[2] = dif;
				}
			}
		}
	}
	if(ans[0] < ans[1])
		cout << ans[0] * 2 + 3 << " " << ans[1] * 2 + 3 << endl;
	else
		cout << ans[1] * 2 + 3 << " " << ans[0] * 2 + 3 << endl;
}