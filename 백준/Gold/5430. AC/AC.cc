#include <cstdio>
#include <queue>

using namespace std;

int T, n, x, temp;
deque<int> D;
char p[100001], input;
bool isFront, isError;

void print_queue(bool isFront);

int main(){
    scanf("%d", &T);
    for(int t = 0; t < T; t++){
        scanf("%s %d", p, &n);
        D.clear();

        input = ' ';
        temp = 0;
        while(input != ']'){
            input = getchar();
            if(input >= '0' && input <= '9')
                temp = temp*10 + (int)(input - '0');
            else if(input == ','){
                D.push_back(temp);
                temp = 0;
            }
        }
        if(n)
            D.push_back(temp);

        isFront = true;
        isError = false;
        temp = 0;
        while(p[temp] != '\0'){
            if(p[temp] == 'R'){
                isFront = !isFront;
            }else if(p[temp] == 'D'){
                if(D.empty()){
                    isError = true;
                    break;
                }
                if(isFront)
                    D.pop_front();
                else
                    D.pop_back();
            }
            temp++;
        }

        if(isError)
            printf("error\n");
        else
           print_queue(isFront);
    }
    return 0;
}

void print_queue(bool isFront){
    printf("[");
    while(!D.empty()){
        if(isFront){
            printf("%d", D.front());
            D.pop_front();
            if(!D.empty())
                printf(",");
        }else{
            printf("%d", D.back());
            D.pop_back();
            if(!D.empty())
                printf(",");
        }     
    }
    printf("]\n");
}