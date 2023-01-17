#include <iostream>
#include <math.h>
using namespace std;
int ck_meetp(double, int, int);
int main()
{
	int T, x1, y1, r1, x2, y2, r2;
	double dis, dx, dy;
	cin >> T;
	for (int i = 0; i < T; i++)
	{
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		dx = (double)x1 - (double)x2;
		dy = (double)y1 - (double)y2;
		dis = dx * dx + dy * dy;
		if(dis)
			dis = sqrt(dis);
		cout << ck_meetp(dis, r1, r2) << endl;
	}
	return 0;
}

int ck_meetp(double d, int r1, int r2)
{
	int plus_r = r1 + r2, min_r = r1 - r2, meetp = 0;
	if (min_r < 0)
		min_r *= -1;
	if (d == plus_r)
		meetp = 1;
	else if (d == 0)
	{
		if (r1 == r2)
			meetp = -1;
	}
	else if (d < plus_r && d > min_r)
		meetp = 2;
	else if (d == min_r)
		meetp = 1;
	else
		meetp = 0;
	return meetp;
}