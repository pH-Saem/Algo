#include <cstdio>
#include <queue>

using namespace std;

int N, mid;
priority_queue<int> maxQ;
priority_queue<int, vector<int>, greater<int>> minQ;

int main(){
    scanf("%d", &N);

    int input;
    scanf("%d", &mid);
    printf("%d\n", mid);
    for(int i = 1; i < N; i++){
        scanf("%d", &input);
        if(input >= mid){
            if(maxQ.size() == minQ.size())
                minQ.push(input);
            else if(maxQ.size() == minQ.size() - 1){
                maxQ.push(mid);
                if(minQ.top() < input){
                    mid = minQ.top();
                    minQ.pop();
                    minQ.push(input);
                }else
                    mid = input;
            }
        }
        else{
            if(maxQ.size() == minQ.size()){
                minQ.push(mid);
                if(!maxQ.empty() && maxQ.top() > input){
                    mid = maxQ.top();
                    maxQ.pop();
                    maxQ.push(input);
                }else
                    mid = input;
            }else if(maxQ.size() == minQ.size() - 1)
                maxQ.push(input);
        }
        printf("%d\n", mid);
    }

    return 0;
}