#include <iostream>
#include <string>

using namespace std;

int main(){
    string input;
    cin >> input;

    cout<<fixed;
    cout.precision(1);
    if(input == "A+")
        cout << 4.3;
    else if(input == "A0")
        cout << 4.0;
    else if(input == "A-")
        cout << 3.7;
    else if(input == "B+")
        cout << 3.3;
    else if(input == "B0")
        cout << 3.0;
    else if(input == "B-")
        cout << 2.7;
    else if(input == "C+")
        cout << 2.3;
    else if(input == "C0")
        cout << 2.0;
    else if(input == "C-")
        cout << 1.7;
    else if(input == "D+")
        cout << 1.3;
    else if(input == "D0")
        cout << 1.0;
    else if(input == "D-")
        cout << 0.7;
    else
        cout << 0.0;
        

    return 0;
}