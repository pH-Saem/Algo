#include <cstdio>

int firstFestivalReward(int rank);
int secondFestivalReward(int rank);

int main(){
    int T, a, b, money;

    scanf("%d", &T);

    for(int t = 0; t < T; t++){
        money = 0;
        scanf("%d %d", &a, &b);
        if(a)
            money += firstFestivalReward(a);
        if(b)
            money += secondFestivalReward(b);

        printf("%d\n", money);
    }


    return 0;
}

int firstFestivalReward(int rank){
    if(rank == 1)
        return 5000000;
    if(rank <= 3)
        return 3000000;
    if(rank <= 6)
        return 2000000;
    if(rank <= 10)
        return 500000;
    if(rank <= 15)
        return 300000;
    if(rank <= 21)
        return 100000;
    return 0;
}

int secondFestivalReward(int rank){
    if(rank & 64 || rank & 32)
        return 0;
    if(rank & 16)
        return 320000;
    if(rank & 8)
        return 640000;
    if(rank & 4)
        return 1280000;
    if(rank & 2)
        return 2560000;
    return 5120000;
}