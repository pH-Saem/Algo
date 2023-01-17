#include <string>
#include <algorithm>
#include <map>
#include <iostream>

using namespace std;

map<string, int> sales;
int N;
char input[51];

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%s", input);
        if(sales.find(input) != sales.end()){
            sales[input]++;
        } else
            sales[input] = 1;
    }

    auto best_seller = max_element(sales.begin(), sales.end(), [](const auto& x, const auto& y){
        return x.second < y.second;
        });

    cout << best_seller->first << '\n';

    return 0;
}