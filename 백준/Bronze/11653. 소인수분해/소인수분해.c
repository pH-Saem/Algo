#include <stdio.h>

int main()
{
    int N, div = 3;

    scanf("%d", &N);

    while (!(N & 1))
    {
        N = N >> 1;
        printf("%d\n", 2);
    }
    
    while (N != 1)
    {
        if (N % div == 0)
        {
            N = N / div;
            printf("%d\n", div);
        }
        else
            div += 2;

        if(div*div > N)
            break;
    } 

    if(N > 1)
        printf("%d\n", N);

    return 0;
}