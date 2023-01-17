#include <cstdio>
#include <map>
#include <string>
#include <cstring>
#include <cstdlib>

using namespace std;

int N, M;
char D[100001][21];
map<string, int> DD;

int main(){
    scanf("%d %d", &N, &M);

    char temp[21];
    for(int i = 1; i <= N; i++){
        scanf("%s", temp);
        strcpy(D[i], temp);
        DD.insert({temp, i});
    }

    for(int i = 0; i < M; i++){
        scanf("%s", temp);
        // 문자인 경우
        if(atoi(temp) == 0){
            printf("%d\n", DD[temp]);
        }
        // 숫자인 경우
        else{
            printf("%s\n", D[atoi(temp)]);
        }
    }


    return 0;
}