#include <iostream>
using namespace std;
class tri
{
private:
	int a;
	int b;
	int c;
public:
	tri()
	{
		a = 0;
		b = 0;
		c = 0;
	}
	void setData(int u_a, int u_b, int u_c)
	{
		a = u_a;
		b = u_b;
		c = u_c;
	}
	void findMax()
	{
		int temp = 0;
		if (c > b)
		{
			temp = b;
			b = c;
			c = temp;
		}
		if (b > a)
		{
			temp = a;
			a = b;
			b = temp;
		}
	}
	void ck_Right()
	{
		a = a * a;
		b = b * b;
		c = c * c;
		if (a == b + c)
			cout << "right" << endl;
		else
			cout << "wrong" << endl;
	}
};

int main()
{
	int a = 1, b = 1, c = 1;
	tri Rt;
	while (1)
	{
		cin >> a >> b >> c;
		if (a == 0 && b == 0 && c == 0)
			break;
		Rt.setData(a, b, c);
		Rt.findMax();
		Rt.ck_Right();
	}
	return 0;
}
