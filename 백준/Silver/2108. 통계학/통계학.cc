#include <cstdio>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int N, sum;
int mean, center, many, range;
int A[500000];
vector<int> M;

int getMode();
int getMean();

int main(){
    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &A[i]);
        sum += A[i];
    }
    sort(A, A+N);

    mean = getMean();

    center = N / 2;
    center = A[center];

    many = getMode();

    range = A[N-1] - A[0];

    printf("%d\n%d\n%d\n%d\n", mean, center, many, range);

    return 0;
}

int getMode(){
    int count = 1, maxCount = 0, mode;
    M.push_back(A[0]);
    for(int i = 1; i < N; i++){     
        if(A[i] == A[i-1])
            count++;
        else{
            if(maxCount < count){
                M.clear();
                M.push_back(A[i-1]);
                maxCount = count;
            }else if(maxCount == count){
                M.push_back(A[i-1]);
            }
            count = 1;
        }
    }

    if(maxCount < count){
        M.clear();
        M.push_back(A[N-1]);
    }else if(maxCount == count){
        M.push_back(A[N-1]);
    }

    sort(M.begin(), M.end());

    if(M.size() == 1)
        mode = M[0];
    else
        mode = M[1];
    
    return mode;
}

int getMean(){
    int mean;
    mean = sum / N;

    if(sum > 0 && (sum%N)*2 >= N)
        mean++;
    else if(sum < 0 && (-sum%N)*2 >= N)
        mean--;

    return mean;
}