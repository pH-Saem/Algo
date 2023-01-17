#include <cstdio>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct student{
    int num;
    int B_count;
    vector<int> A;

    bool operator<(const student &other) const {
        return this->B_count < other.B_count;
    }
};

int N, M, A, B;
student S[32001];
int P[32001];

int main(){
    scanf("%d %d", &N, &M);

    for(int i = 1; i <= N; i++){
        S[i].num = i;
        S[i].B_count = 0;
    }

    for(int i = 0; i < M; i++){
        scanf("%d %d", &A, &B);
        S[A].B_count++;
        S[B].A.push_back(A);
    }
    
    queue<student> Q;
    
    for(int i = 1; i <= N; i++){
        if(S[i].B_count == 0)
            Q.push(S[i]);
    }

    student temp;
    int ind = N;
    while(!Q.empty()){
        temp = Q.front();
        Q.pop();
        P[ind--] = temp.num;
        for(int i = 0; i < temp.A.size(); i++){
            S[temp.A[i]].B_count--;
            if(S[temp.A[i]].B_count == 0)
                Q.push(S[temp.A[i]]);
        }
    }
    
    if(N == 1)
        printf("1");
    else{
        for(int i = 1; i <= N; i++)
            printf("%d ", P[i]);
    }
    printf("\n");

    return 0;
}