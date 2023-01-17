#include <queue>
#include <string>

using namespace std;
priority_queue<string, vector<string>, greater<string>> words[51];

int main(){
    int N;
    char temp[51];
    string input;

    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%s", temp);
        input = temp;
        words[input.length()].push(input);
    }

    string prev = " ", output;
    for(int i = 1; i <= 50; i++){
        while(!words[i].empty()){
            output = words[i].top();
            words[i].pop();
            if(prev != output){
                printf("%s\n", output.c_str());
                prev = output;
            }
        }
    }

    return 0;
}