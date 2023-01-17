#include <iostream>
using namespace std;
int shortDis(int p, int m);
int main()
{
	int x, y, w, h, xd, yd;
	cin >> x >> y >> w >> h;
	xd = shortDis(x, w);
	yd = shortDis(y, h);
	if (xd < yd)
		cout << xd;
	else
		cout << yd;
	return 0;
}

int shortDis(int p, int m)
{
	if (p > m - p)
		return m - p;
	else
		return p;
}