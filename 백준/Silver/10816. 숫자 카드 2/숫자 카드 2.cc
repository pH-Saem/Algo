#include <cstdio>
#include <algorithm>
#include <vector>

using namespace std;

struct card{
    int v;
    int i;
    bool operator<(const card& other) const {
        return this->v < other.v;
    }
};

int N, M, input;
int answer[500000];
vector<int> Ns;
vector<card> Ms;

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &input);
        Ns.push_back(input);
    }
    scanf("%d", &M);
    for(int i = 0; i < M; i++){
        scanf("%d", &input);
        Ms.push_back({input, i});
    }

    sort(Ns.begin(), Ns.end());
    sort(Ms.begin(), Ms.end());

    int N_ind = 0, cnt, prev;
    for(auto i : Ms){
        if(prev != i.v)
        {
            cnt = 0;
            while(N_ind < N && Ns[N_ind] < i.v)
                N_ind++;
            while(N_ind < N && Ns[N_ind] == i.v){
                cnt++;
                N_ind++;
            }
            prev = i.v;
        }
        answer[i.i] = cnt;
    }

    for(int i = 0; i < M; i++)
        printf("%d ", answer[i]);
    printf("\n");

    return 0;
}