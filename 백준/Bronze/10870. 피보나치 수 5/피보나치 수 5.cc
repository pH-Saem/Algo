#include <iostream>
int Fibo(int N, int[]);
int main()
{
	int N, data[21] = { 0,1,1 };
	std::cin >> N;
	std::cout << Fibo(N,data);
	return 0;
}

int Fibo(int N, int data[])
{
	if (N == 0)
		return 0;
	else if (N == 1 || N == 2)
		return 1;
	else if (data[N])
		return data[N];
	else
	{
		data[N] = Fibo(N-2, data) + Fibo(N-1,data);
		return data[N];
	}

}