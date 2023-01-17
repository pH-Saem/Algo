#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<string> S;
string s;

int main(){
    cin >> s;

    for(int i = 0; i < s.length(); i++){
        S.push_back(s.substr(i, s.length() - i));
    }

    sort(S.begin(), S.end());

    for(int i = 0; i < s.length(); i++){
        cout << S[i] << '\n';
    }

    return 0;
}