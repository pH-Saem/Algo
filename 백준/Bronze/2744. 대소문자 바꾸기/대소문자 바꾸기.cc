#include <cstdio>
#include <cstring>

char S[101];
int len;

int main(){
    scanf("%s", S);
    len = strlen(S);
    
    for(int i = 0; i < len; i++){
        if(S[i] < 97)
            printf("%c", S[i]+32);
        else
            printf("%c", S[i]-32);
    }
    printf("\n");
    
    return 0;
}