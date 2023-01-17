#include <cstdio>
#include <cstring>
#include <cstdlib>

#define MAX 1000000000

int N;
int stack[1000], ind, sp;
char stmt[100000][10];
char temp[10];
bool isError;

int setStatements();
void goStack();

int main(){
    while(1){
        ind = -1;
        if(setStatements())
            break;
        scanf("%d", &N);
        for(int i = 0; i < N; i++){
            scanf("%d", stack);
            goStack();
            if(isError || sp != 1)
                printf("ERROR\n");
            else
                printf("%d\n", stack[0]);
        }
        printf("\n");
    }
    return 0;
}

int setStatements(){
    while(1){
        scanf("%s", stmt[++ind]);
        if(strcmp(stmt[ind], "QUIT") == 0)
            return 1;
        if(strcmp(stmt[ind], "NUM") == 0){
            scanf("%s", stmt[ind]);
            continue;
        }
        if(strcmp(stmt[ind], "END") == 0)
            break;
    }
    return 0;
}

void goStack(){
    sp = 1;
    isError = false;
    for(int i = 0; i < ind; i++){
        if(strcmp(stmt[i], "POP") == 0){
            if(sp == 0){
                isError = true;
                break;
            }
            sp--;
        }
        else if(strcmp(stmt[i], "INV") == 0){
            if(sp == 0){
                isError = true;
                break;
            }
            stack[sp-1] = -stack[sp-1];
        }
        else if(strcmp(stmt[i], "DUP") == 0){
            if(sp == 0){
                isError = true;
                break;
            }
            stack[sp] = stack[sp-1];
            sp++;
        }
        else if(strcmp(stmt[i], "SWP") == 0){
            if(sp <= 1){
                isError = true;
                break;
            }
            int temp = stack[sp-1];
            stack[sp-1] = stack[sp-2];
            stack[sp-2] = temp;
        }
        else if(strcmp(stmt[i], "ADD") == 0){
            if(sp <= 1){
                isError = true;
                break;
            }
            stack[sp-2] += stack[sp-1];
            if(stack[sp-2] < -MAX || stack[sp-2] > MAX){
                isError = true;
                break;
            }
            sp--;
        }
        else if(strcmp(stmt[i], "SUB") == 0){
            if(sp <= 1){
                isError = true;
                break;
            }
            stack[sp-2] -= stack[sp-1];
            if(stack[sp-2] < -MAX || stack[sp-2] > MAX){
                isError = true;
                break;
            }
            sp--;
        }
        else if(strcmp(stmt[i], "MUL") == 0){
            if(sp <= 1){
                isError = true;
                break;
            }
            long long temp = (long long)stack[sp-1] * stack[sp-2];
            if(temp < -MAX || temp > MAX){
                isError = true;
                break;
            }
            stack[sp-2] = (int)temp;
            sp--;
        }
        else if(strcmp(stmt[i], "DIV") == 0){
            if(sp <= 1 || stack[sp-1] == 0){
                isError = true;
                break;
            }
            stack[sp-2] = stack[sp-2]/stack[sp-1];            
            sp--;
        }
        else if(strcmp(stmt[i], "MOD") == 0){
            if(sp <= 1 || stack[sp-1] == 0){
                isError = true;
                break;
            }
            stack[sp-2] = stack[sp-2]%stack[sp-1];            
            sp--;
        }
        else{
            stack[sp++] = atoi(stmt[i]);
        }
    }
}