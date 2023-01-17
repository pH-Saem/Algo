#include <iostream>
int Facto(int N);
int main()
{
	int N;
	std::cin >> N;

	std::cout << Facto(N);

	return 0;
}

int Facto(int N)
{
	if (N == 1 || N == 0)
		return 1;
	else
		return Facto(N-1) * N;
}