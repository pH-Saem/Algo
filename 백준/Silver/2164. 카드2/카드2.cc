#include <cstdio>
#include <queue>

using namespace std;

int N;
deque<int> deck;

int main(){
    scanf("%d", &N);
    for(int i = 1; i <= N; i++)
        deck.push_back(i);
    
    int temp;
    while(deck.size() != 1){
        deck.pop_front();
        temp = deck.front();
        deck.pop_front();
        deck.push_back(temp);
    }

    printf("%d\n", deck.front());

    return 0;
}