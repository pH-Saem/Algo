#include <cstdio>
#include <cmath>
#include <limits>

int N, K;
int dolls[500];
int sum, K_sum, input;
double min, temp;

double dispersion(int index, int sum, int length);

int main(){
    scanf("%d %d", &N, &K);

    for(int i = 0; i < N; i++){
        scanf("%d", &input);
        dolls[i] = input;
    }

    for(int i = 0; i < K - 1; i++)
        K_sum += dolls[i];
    
    min = 1000000000000;
    for(int i = K-1; i < N; i++){
        sum = K_sum;
        for(int j = 0; j < N-i; j++){
            sum += dolls[i+j];
            temp = dispersion(i+j, sum, K+j);
            temp = temp / (K+j);
            if(temp < min)
                min = temp;
        }
        K_sum = K_sum - dolls[i - K + 1] + dolls[i];
    }

    min = sqrt(min);

    printf("%.11lf\n", min);

    return 0;
}

// 분산 구하는 함수
double dispersion(int index, int sum, int length){
    double mean = (double)sum / length;
    double result = 0;

    for(int i = length - 1; i >= 0; i--)
        result += (dolls[index-i] - mean)*(dolls[index-i] - mean);

    return result;
}