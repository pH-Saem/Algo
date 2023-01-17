#include <iostream>

using namespace std;

int main(){
    int N, v, cnt=0, *A;

    cin >> N;
    A = new int[N];
    for(int i = 0; i < N; i++){
        cin >> A[i];
    }

    cin >> v;
    for(int i = 0; i < N; i++){
        if(A[i] == v){
            cnt++;
        }
    }

    cout << cnt;
    delete[] A;
    return 0;
}