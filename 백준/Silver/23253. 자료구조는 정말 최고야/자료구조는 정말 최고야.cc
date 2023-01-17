#include <cstdio>
#include <vector>
#include <queue>

using namespace std;

struct book{
    int index;
    int order;
    int level;
    bool operator<(const book &other) const {
        return this->order > other.order;
    }
};

int N, M;
vector<int> dummy;
priority_queue<book> books;

int main(){
    scanf("%d %d", &N, &M);

    int k, num;
    for(int i = 0; i < M; i++){
        scanf("%d", &k);
        dummy.push_back(1);
        for(int j = 0; j < k; j++){
            scanf("%d", &num);
            books.push({i, num, k-j});
        }
    }

    int order = 1;
    book curr;
    bool isPossible = true;
    while(!books.empty()){
        curr = books.top();
        books.pop();

        if(curr.order != order++ || curr.level != dummy[curr.index]++){
            isPossible = false;
            break;
        }
    }
    
    if(isPossible)
        printf("Yes\n");
    else
        printf("No\n");

    return 0;
}