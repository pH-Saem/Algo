#include <cstdio>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int N, dough_price, topping_price, dough_cal;
vector<int> topping_cal;

int main(){
    scanf("%d %d %d %d", &N, &dough_price, &topping_price, &dough_cal);

    int temp;
    for(int i = 0; i < N; i++){
        scanf("%d", &temp);
        topping_cal.push_back(temp);
    }

    sort(topping_cal.begin(), topping_cal.end());

    double cal = dough_cal, price = dough_price, best_piz = cal / price;
    for(int i = N-1; i >= 0; i--){
        cal += topping_cal[i];
        price += topping_price;

        if(best_piz < cal/price){
            best_piz = cal/price;
        } else
            break;
    }

    printf("%d\n", (int)floor(best_piz));

    return 0;
}