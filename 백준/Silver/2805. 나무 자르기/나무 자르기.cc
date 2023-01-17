#include <cstdio>
#include <algorithm>

int N;
long long M;
long long trees[1000000];
long long H;
long long sum;

using namespace std;

bool compare(const long long &a, const long long &b)
{
	if (a > b)
		return true;
	return false;
}

int main()
{
	scanf("%d %lld", &N, &M);
	for (int i = 0; i < N; i++)
	{
		scanf("%lld", trees + i);
	}

	sort(trees, trees + N, compare);

	sum = 0;
	long long temp;
	int i = 1;
	for (; i < N; i++)
	{
		temp = trees[i - 1] - trees[i];
		if (temp == 0)
			continue;
		if (sum + temp * i >= M)
			break;
		else
			sum += temp * i;
	}

	if (sum + temp * i == M)
		H = trees[i];
	else
	{
		temp = (M - sum) / i;
		if ((M - sum) % i != 0)
			temp++;
		H = trees[i - 1] - temp;
	}

	printf("%lld\n", H);

	return 0;
}