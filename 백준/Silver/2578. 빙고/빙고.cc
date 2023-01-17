#include <cstdio>
#include <algorithm>

using namespace std;

int A[26], R[5], C[5], X[2], input;

int main(){
    for(int i = 0; i < 25; i++){
        scanf("%d", &input);
        A[input] = i;
    }

    for(int i = 0; i < 5; i++){
        R[i] = 5;
        C[i] = 5;
    }
    X[0] = 5, X[1] = 5;

    int Ri, Ci, count = 0;
    for(int i = 1; i <= 25; i++){
        scanf("%d", &input);
        Ri = A[input]/5;
        Ci = A[input]%5;
        R[Ri]--; C[Ci]--;
        if(Ri == Ci)
            X[0]--;
        if(Ri + Ci == 4)
            X[1]--;
        if(X[0] == 0){
            count++;
            X[0] = 100;
        }
        if(X[1] == 0){
            count++;
            X[1] = 100;
        }
        if(R[Ri] == 0)
            count++;
        if(C[Ci] == 0)
            count++;
        if(count >= 3){
            printf("%d\n", i);
            break;
        }
    }

    return 0;
}