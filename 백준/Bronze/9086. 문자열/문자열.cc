#include <cstdio>
#include <cstring>

int T, len;
char S[1001];

int main(){
    scanf("%d", &T);

    for(int t = 0; t < T; t++){
        scanf("%s", S);
        len = strlen(S);
        printf("%c%c\n", S[0], S[len-1]);
    }
    return 0;
}