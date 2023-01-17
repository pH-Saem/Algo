#include <cstdio>
#include <stack>

using namespace std;

int main(){
    int T;
    char input = ' ';
    bool isVPS;
    stack<char> S;

    scanf("%d", &T);
    getchar();

    for(int i = 0; i < T; i++){
        isVPS = true;
        while(!S.empty())
            S.pop();

        while(1){
            input = getchar();
            if(input == '\n' || input == EOF)
                break;

            if(isVPS){
                if(input == '('){
                    S.push(input);
                }
                else if(S.empty()){
                    isVPS = false;
                }else{
                    S.pop();
                }
            }
        }

        if(!S.empty())
            isVPS = false;
        
        if(isVPS)
            printf("YES\n");
        else
            printf("NO\n");
    }

    return 0;
}