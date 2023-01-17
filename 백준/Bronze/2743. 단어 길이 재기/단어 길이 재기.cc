#include <cstdio>

char S[101];

int main(){
    scanf("%s", S);
    for(int i = 0; i <= 100; i++){
        if(S[i] == NULL){
            printf("%d\n", i);
            break;
        }
    }
    return 0;
}