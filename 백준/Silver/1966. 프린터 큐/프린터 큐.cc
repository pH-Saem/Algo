#include <cstdio>
#include <queue>
#include <vector>
#include <algorithm>

using namespace std;

struct doc{
    int i;
    int p;
};

int T, N, M;
int answer;
queue<doc> Q;
vector<int> V;

int main(){
    scanf("%d", &T);
    for(int t = 0; t < T; t++){
        scanf("%d %d", &N, &M);

        answer = 0;
        while(!Q.empty())
            Q.pop();
        V.clear();

        // 입력받기
        int input;
        for(int i = 0; i < N; i++){
            scanf("%d", &input);
            Q.push({i, input});
            V.push_back(input);
        }

        sort(V.begin(), V.end());

        doc temp;
        for(int i = V.size() - 1; i >= 0; i--){
            while(1){
                temp = Q.front();
                if(V[i] == temp.p){
                    Q.pop();
                    answer++;
                    break;
                }else{
                    Q.pop();
                    Q.push(temp);
                }
            }
            if(temp.i == M)
                break;
        }

        printf("%d\n", answer);
    }
    return 0;
}