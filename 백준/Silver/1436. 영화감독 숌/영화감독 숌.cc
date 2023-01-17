#include <cstdio>
#include <string>

using namespace std;

int N, count, num = 666;

bool checkNum();

int main(){
    scanf("%d", &N);
    while(count != N){
        if(checkNum())
            count++;
        num++;
    }
    printf("%d\n", num-1);
    return 0;
}

bool checkNum(){
    if(to_string(num).find("666") == string::npos)
        return false;
    else
        return true;
}