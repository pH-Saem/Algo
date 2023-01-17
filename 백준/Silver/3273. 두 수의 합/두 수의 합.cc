#include <cstdio>
#include <algorithm>

int n, x, A[100000];
int s, e;
long long cnt;

int main(){
    scanf("%d", &n);
    for(int i = 0; i < n; i++)
        scanf("%d", &A[i]);
    scanf("%d", &x);

    std::sort(A, A + n);

    for(e = n-1; e > s; e--){
        while(A[s] + A[e] < x){
            s++;
        }
        if(e <= s)
            break;
        if(A[s] + A[e] == x){
            cnt++;
        }
    }
    
    printf("%lld\n", cnt);

    return 0;
}