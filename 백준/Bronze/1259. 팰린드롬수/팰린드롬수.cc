#include <cstdio>
#include <cstring>
#include <string>
#include <algorithm>

using namespace std;

int main(){
    int input, reversed_input;
    string temp;

    while(1){
        scanf("%d", &input);

        if(input == 0)
            break;

        temp = to_string(input);
        reverse(temp.begin(), temp.end());
        reversed_input = atoi(temp.c_str());

        if(input == reversed_input)
            printf("yes\n");
        else
            printf("no\n");
    }
}