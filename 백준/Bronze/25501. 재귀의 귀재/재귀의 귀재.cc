#include <cstdio>
#include <cstring>

int T, count;
char S[1001];

int recursion(const char* s, int l, int r){
    count++;
    if(l >= r) return 1;
    else if(s[l] != s[r]) return 0;
    else return recursion(s, l+1, r-1);
}

int isPalindrome(const char* s){
    return recursion(s, 0, strlen(s)-1);
}

int main(){
    scanf("%d", &T);
    for(int t = 0; t < T; t++){
        scanf("%s", S);
        count = 0;
        printf("%d ", isPalindrome(S));
        printf("%d\n", count);
    }
}