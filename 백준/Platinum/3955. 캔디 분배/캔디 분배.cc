#include <cstdio>

typedef struct _expression
{
	long long s;
	long long t;
	long long r;
} expression;

int gcd(int a, int b);
int ext_euclid(expression a, expression b);

expression a, b;

int main()
{
	int t, K, C;
	scanf("%d", &t);

	for (int i = 0; i < t; i++)
	{
		scanf("%d %d", &K, &C);
		if (gcd(K, C) != 1)
			printf("IMPOSSIBLE\n");
		else
		{
            long long ans;
            if(K == 1 && C == 1)
                ans = 2;
            else if(K == 1){
                ans = 2;
            }
            else if(C == 1){
                ans = K+1;
            }
            else{
                expression a, b;
                a.s = 1;
                a.t = 0;
                a.r = C;
                b.s = 0;
                b.t = 1;
                b.r = K;

                ans = ext_euclid(a, b);
                if (ans < 0)
                    ans += K;
            }
            if(ans <= 1000000000)
			    printf("%d\n", ans);
            else
                printf("IMPOSSIBLE\n");
		}
	}

	return 0;
}

int gcd(int a, int b)
{
	if (b == 0)
		return a;
	return gcd(b, a % b);
}

int ext_euclid(expression a, expression b)
{
	expression c;
	long long r = a.r / b.r;
	c.r = a.r % b.r;
	c.s = a.s - b.s * r;
	c.t = a.t - b.t * r;

	if (c.r == 1)
		return c.s;
	return ext_euclid(b, c);
}