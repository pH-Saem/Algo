#include <cstdio>
#include <cstring>

struct node{
    int value;
    node *next;
    node *prev;
};

struct deque{
    int size;
    node *head;
    node *tail;
};

deque D;
node *temp;
int N, num;
char stmt[11];

int main(){
    D.size = 0;
    scanf("%d", &N);
    for(int n = 0; n < N; n++){
        scanf("%s", stmt);
        if(strcmp(stmt, "push_back") == 0){
            scanf("%d", &num);
            temp = new node({num, nullptr, nullptr});
            if(D.size){
                temp->prev = D.tail;
                D.tail->next = temp;
                D.tail = temp;
            }else{
                D.tail = temp;
                D.head = temp;    
            }
            D.size++;
        }else if(strcmp(stmt, "push_front") == 0){
            scanf("%d", &num);
            temp = new node({num, nullptr, nullptr});
            if(D.size){
                temp->next = D.head;
                D.head->prev = temp;
                D.head = temp;
            }else{
                D.head = temp;    
                D.tail = temp;
            }
            D.size++;
        }else if(strcmp(stmt, "pop_front") == 0){
            if(D.size){
                printf("%d\n", D.head->value);
                D.head = D.head->next;
                if(D.head)
                    D.head->prev = nullptr;
                D.size--;
            }else
                printf("-1\n");
        }else if(strcmp(stmt, "pop_back") == 0){
            if(D.size){
                printf("%d\n", D.tail->value);
                D.tail = D.tail->prev;
                if(D.tail)
                    D.tail->next = nullptr;
                D.size--;
            }else
                printf("-1\n");
        }else if(strcmp(stmt, "size") == 0){
            printf("%d\n", D.size);
        }else if(strcmp(stmt, "empty") == 0){
            if(D.size)
                printf("0\n");
            else
                printf("1\n");            
        }else if(strcmp(stmt, "front") == 0){
            if(D.size){
                printf("%d\n", D.head->value);
            }else
                printf("-1\n");
        }else if(strcmp(stmt, "back") == 0){
            if(D.size){
                printf("%d\n", D.tail->value);
            }else
                printf("-1\n");
        }
    }

    return 0;
}