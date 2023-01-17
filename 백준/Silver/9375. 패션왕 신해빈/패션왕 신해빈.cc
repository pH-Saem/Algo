#include <cstdio>
#include <cstring>
#include <vector>

struct cloth{
    char category[21];
    int count;
};

int T, n, answer;
char input[21];
bool isNewCategory;
cloth temp;
std::vector<cloth> clothes;

int main(){
    scanf("%d", &T);
    for(int t = 0; t < T; t++){
        clothes.clear();
        scanf("%d", &n);

        for(int i = 0; i < n; i++){
            scanf("%s %s", input, input);
            isNewCategory = true;
            for(int j = 0; j < clothes.size(); j++){
                if(strcmp(clothes[j].category, input) == 0){
                    clothes[j].count++;
                    isNewCategory = false;
                }
            }

            if(isNewCategory){
                strcpy(temp.category, input);
                temp.count = 1;
                clothes.push_back(temp);
            }
        }

        answer = 1;
        for(auto c : clothes)
            answer *= (c.count+1);
        printf("%d\n", answer-1); 
    }
    return 0;
}