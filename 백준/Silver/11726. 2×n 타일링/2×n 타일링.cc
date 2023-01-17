#include <cstdio>

int n, answer[1001];

int tiling(int ind);

int main(){
    scanf("%d", &n);

    answer[0] = 1; answer[1] = 1;
    printf("%d\n", tiling(n));

    return 0;
}

int tiling(int ind){
    if(answer[ind])
        return answer[ind];
    else{
        int temp = tiling(ind-1) + tiling(ind-2);
        if(temp > 10007)
            temp %= 10007;
        return answer[ind] = temp;
    }
}