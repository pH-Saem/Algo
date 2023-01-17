#include <cstdio>
#include <map>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
char input[21];
map<string, int> A;
vector<string> L;

int main(){
    scanf("%d %d", &N, &M);
    // 듣도 못한 사람 입력 및 map에 저장
    for(int i = 0; i < N; i++){
        scanf("%s", input);
        A[input] = 0;
    }
   
    // 보도 못한 사람 입력 및 map에서 검색
    // 존재하면 L에 저장
    for(int i = 0; i < M; i++){
        scanf("%s", input);
        if(A.find(input) != A.end()){
            L.push_back(input);
        }
    }
    
    // 듣도 보도 못한 사람 사전 순 정렬
    sort(L.begin(), L.end());

    int size = L.size();
    printf("%d\n", size);
    for(int i = 0; i < size; i++){
        printf("%s\n", L[i].c_str());
    }

    return 0;
}