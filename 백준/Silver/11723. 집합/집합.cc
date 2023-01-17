#include <cstdio>
#include <cstring>

int M, x, set;
char stmt[10];

int main(){
    scanf("%d", &M);

    int temp;
    for(int i = 0; i < M; i++){
        scanf("%s", stmt);
        if(strcmp(stmt, "add") == 0){
            scanf("%d", &x);
            temp = 1 << x;
            set = set | temp;
        }
        if(strcmp(stmt, "remove") == 0){
            scanf("%d", &x);
            temp = ~(1 << x);
            set = set & temp;
        }
        if(strcmp(stmt, "check") == 0){
            scanf("%d", &x);
            temp = 1 << x;
            if(set & temp)
                printf("1\n");
            else
                printf("0\n");
        }
        if(strcmp(stmt, "toggle") == 0){
            scanf("%d", &x);
            temp = 1 << x;
            if(set & temp)
                set -= temp;
            else
                set += temp;
        }
        if(strcmp(stmt, "all") == 0){
            set = (1 << 21) - 1;
        }
        if(strcmp(stmt, "empty") == 0){
            set = 0;
        }
    }


    return 0;
}