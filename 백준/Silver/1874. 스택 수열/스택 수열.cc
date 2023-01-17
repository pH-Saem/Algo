#include <cstdio>
#include <stack>
#include <string>

using namespace std;

int n, input, curr;
bool isPossible = true;
string answer;
stack<int> S;

int main(){
    scanf("%d", &n);
    for(int i = 0; i < n; i++){
        scanf("%d", &input);
        if(isPossible){
            while(input > curr){
                S.push(++curr);
                answer += "+\n";
                //printf("%d ", S.top());
            }
            if(input == S.top()){
                S.pop();
                answer += "-\n";
            }
            else if(input < S.top()){
                isPossible = false;
            }
        }
    }

    if(isPossible)
        printf("%s", answer.c_str());
    else
        printf("NO\n");

    return 0;
}