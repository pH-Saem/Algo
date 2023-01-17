#include <iostream>
using namespace std;

int main()
{
	int x[4] = { 0, }, y[4] = { 0, }, ans[2] = { 0, };
	for (int i = 0; i < 3; i++)
		cin >> x[i] >> y[i];
	for (int i = 0; i < 3; i++)
	{
		if (!x[3])
			x[3] = x[i];
		else if (x[3] == x[i])
			x[3] = 0;
		else
			ans[0] = x[i];

		if (!y[3])
			y[3] = y[i];
		else if (y[3] == y[i])
			y[3] = 0;
		else
			ans[1] = y[i];
	}
	if (!x[3])
		cout << ans[0] << " ";
	else
		cout << x[3] << " ";
	if (!y[3])
		cout << ans[1];
	else
		cout << y[3];

	return 0;
}