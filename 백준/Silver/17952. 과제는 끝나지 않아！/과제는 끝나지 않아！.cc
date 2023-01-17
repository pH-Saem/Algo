#include <cstdio>
#include <stack>

using namespace std;

struct Assignment{
    int score;
    int t;
};

int N, Answer;
stack<Assignment> A;

int main(){
    scanf("%d", &N);

    int input, score, t;
    Assignment curr = {0, 0};
    for(int i = 0; i < N; i++){
        scanf("%d", &input);
        if(input){
            scanf("%d %d", &score, &t);
            A.push({score, t});
        }
        if(!A.empty()){
            curr = A.top();
            curr.t -= 1;
            A.pop();
            if(curr.t == 0)
                Answer += curr.score;
            else
                A.push(curr);
        }  
    }
    printf("%d\n", Answer);

    return 0;
}