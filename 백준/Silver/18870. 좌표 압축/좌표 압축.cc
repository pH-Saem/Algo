#include <cstdio>
#include <algorithm>

using namespace std;

struct X{
    int x;
    int i;
    bool operator<(const X &other) const{
        return this->x < other.x;
    }
};

int N;
X A[1000001];
int result[1000001];

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &A[i].x);
        A[i].i = i;
    }

    std::sort(A, A+N);

    int xi = 0;
    for(int i = 0; i < N; i++){
        result[A[i].i] = xi;
        if(A[i].x != A[i+1].x)
            xi++;
    }

    for(int i = 0; i < N; i++)
        printf("%d ", result[i]);
    printf("\n");

    return 0;
}