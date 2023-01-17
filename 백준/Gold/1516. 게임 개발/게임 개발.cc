#include <cstdio>
#include <vector>

using namespace std;

struct building{
    int time;
    int total;
    vector<int> req;
};

int N, input;
building B[501];

int getTotalTime(int num);

int main(){
    scanf("%d", &N);

    for(int i = 1; i <= N; i++){
        scanf("%d", &input);
        B[i].time = input;
        B[i].total = 0;
        while(1){
            scanf("%d", &input);
            if(input == -1)
                break;
            B[i].req.push_back(input);
        }
    }

    for(int i = 1; i <= N; i++){
        printf("%d\n", getTotalTime(i));
    }

    return 0;
}

int getTotalTime(int num){
    int result = 0, req_size, max = 0, temp;

    if(B[num].total)
        result = B[num].total;
    else{
        req_size = B[num].req.size();
        if(req_size == 0){
            result = B[num].time;
            B[num].total = result;
        }else{
            for(int i = 0; i < req_size; i++){
                temp = getTotalTime(B[num].req[i]);
                max = max > temp ? max : temp;
            }
            result = B[num].time + max;
            B[num].total = result;
        }
    }

    return result;
}