#include <cstdio>

int main(){
    int input, answer = 0;
    for(int i = 0; i < 5; i++){
        scanf("%d", &input);
        answer += input * input;
    }
    printf("%d\n", answer%10);
    return 0;
}