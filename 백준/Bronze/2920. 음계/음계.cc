#include <cstdio>

int main(){
    bool isAscending = false;
    bool isDescending = false;
    int input;

    scanf("%d", &input);
    if(input == 8)
        isDescending = true;
    if(input == 1)
        isAscending = true;
    
    for(int i = 2; i <= 8; i++){
        scanf("%d", &input);
        if(isAscending && input != i)
            isAscending = false;
        if(isDescending && input != 9 - i)
            isDescending = false;
    }

    if(isAscending)
        printf("ascending\n");
    else if(isDescending)
        printf("descending\n");
    else
        printf("mixed\n");

    return 0;
}