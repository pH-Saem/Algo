#include <cstdio>

int T, n, A[11] = {0, 1, 2, 4};

int getNumberOfPlus(int target){
    if(A[target])
        return A[target];
    else
        return A[target] = getNumberOfPlus(target-1) + getNumberOfPlus(target-2) + getNumberOfPlus(target-3);
}

int main(){
    scanf("%d", &T);

    for(int t = 0; t < T; t++){
        scanf("%d", &n);
        printf("%d\n", getNumberOfPlus(n));
    }

    return 0;
}