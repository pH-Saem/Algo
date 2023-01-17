#include <cstdio>
#include <stack>

int main(){
    int K, input, answer = 0;
    std::stack<int> S;

    scanf("%d", &K);

    for(int i = 0; i < K; i++){
        scanf("%d", &input);
        if(input == 0)
            S.pop();
        else
            S.push(input);
    }

    while(!S.empty()){
        answer += S.top();
        S.pop();
    }

    printf("%d\n", answer);

    return 0;
}