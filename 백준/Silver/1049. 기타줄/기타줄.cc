#include <cstdio>

int N, M, ans, set = 1001, one = 1001;

int main(){
    scanf("%d %d", &N, &M);
    int t1, t2;
    for(int i = 0; i < M; i++){
        scanf("%d %d", &t1, &t2);
        if(set > t1)
            set = t1;
        if(one > t2)
            one = t2;
    }
    if(set >= one*6){
        ans = one*N;
    } else{
        ans = set*(N/6);
        if(set >= one*(N%6))
            ans += one*(N%6);
        else
            ans += set;
    }
    printf("%d\n", ans);

    return 0;
}