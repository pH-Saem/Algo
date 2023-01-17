#include <cstdio>

int N, r, c, n = 1;
int count;
bool isEnd = false;

bool checkNInRange(int x, int y, int len);
void checkZ(int x, int y, int len);

int main(){
    scanf("%d %d %d", &N, &r, &c);

    n = n << N;

    checkZ(0, 0, n);

    return 0;
}

void checkZ(int x, int y, int len){
    if(isEnd)
        return;

    if(len == 1){
        if(checkNInRange(x, y, len)){
            isEnd = true;
            printf("%d\n", count);
        } else
            count++;
    } else{
        if(checkNInRange(x, y, len)){
            int newLen = len >> 1;
            checkZ(x, y, newLen);
            checkZ(x+newLen, y, newLen);
            checkZ(x, y+newLen, newLen);
            checkZ(x+newLen, y+newLen, newLen);
        } else
            count += len * len;
    }
}

bool checkNInRange(int x, int y, int len){
    int end_x = x + len - 1;
    int end_y = y + len - 1;
    if(c >= x && c <= end_x && r >= y && r <= end_y)
        return true;
    else
        return false;
}