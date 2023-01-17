#include <cstdio>
#include <algorithm>
#include <string>
#include <vector>

using namespace std;

struct student{
    string name;
    int kor;
    int eng;
    int math;
};

int N;
vector<student> students;

bool compare(const student& a, const student& b){
    if(a.kor > b.kor)
        return true;
    else if(a.kor == b.kor){
        if(a.eng < b.eng)
            return true;
        else if(a.eng == b.eng){
            if(a.math > b.math)
                return true;
            else if(a.math == b.math){
                return a.name < b.name;
            }
        }
    }
    return false;
}

int main(){
    scanf("%d", &N);

    char name[11];
    int ko, en, ma;
    for(int i = 0; i < N; i++){
        scanf("%s %d %d %d", name, &ko, &en, &ma);
        students.push_back({name, ko, en, ma});
    }

    stable_sort(students.begin(), students.end(), compare);

    for(int i = 0; i < N; i++){
        printf("%s\n", students[i].name.c_str());
    }

    return 0;
}