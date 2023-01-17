#include <cstdio>

int main(){
    int sID[31] = {0,};
    int n;
    for(int i = 0; i < 28; i++){
        scanf("%d", &n);
        sID[n] = 1;
    }
    for(int i = 1; i < 31; i++){
        if(!sID[i]){
            printf("%d\n", i);
        }
    }
    return 0;
}