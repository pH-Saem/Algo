#include <cstdio>
#include <stack>

using namespace std;

stack<char> S;
bool isBalanced;

int main(){
    char input;
    while(1){
        input = getchar();
        if(input == '.')
            break;
        isBalanced = true;
        while(!S.empty())
            S.pop();
        while(1){
            if(input == '(' || input == '[')
                S.push(input);
            else if(input == ')' || input == ']'){
                if(S.empty())
                    isBalanced = false;
                else if(input == ')' && S.top() == '(')
                    S.pop();
                else if(input == ']' && S.top() == '[')
                    S.pop();
                else
                    isBalanced = false;
            }else if(input == '.'){
                getchar();
                if(isBalanced && S.empty())
                    printf("yes\n");
                else
                    printf("no\n");
                break;
            }
            input = getchar();
        }
    }

    return 0;
}