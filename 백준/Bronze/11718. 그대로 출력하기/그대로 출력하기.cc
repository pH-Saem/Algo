#include <cstdio>

char input;

int main(){
    input = ' ';
    while(1){
        input = getchar();
        if(input == EOF)
            break;
        printf("%c", input);
    }
    return 0;
}