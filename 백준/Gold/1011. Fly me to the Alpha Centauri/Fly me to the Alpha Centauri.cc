#include <iostream>
#include <math.h>
using namespace std;
int main()
{
	int T, x, y, dis, ans;
	double temp = 0;
	cin >> T;
	for (int i = 0; i < T; i++)
	{
		x = 0;
		y = 0;
		cin >> x >> y;
		dis = y - x;
		temp = sqrt((double)dis);
		x = (int)temp;
		if (temp - x == 0)
			ans = 2 * x - 1;
		else
		{
			if (dis <= x * (x + 1))
				ans = 2 * x;
			else
				ans = 2 * x + 1;
		}
		
		cout << ans << endl;
	}
	return 0;
}
