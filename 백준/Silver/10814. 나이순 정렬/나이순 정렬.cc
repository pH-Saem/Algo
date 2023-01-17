#include <cstdio>
#include <algorithm>

using namespace std;

struct member{
    int age;
    char name[101];
    bool operator<(const member &other)const{
        return this->age < other.age;
    }
};

member M[100000];
int N;

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d %s", &M[i].age, &M[i].name);
    }

    stable_sort(M, M+N);

    for(int i = 0; i < N; i++)
        printf("%d %s\n", M[i].age, M[i].name);

    return 0;
}