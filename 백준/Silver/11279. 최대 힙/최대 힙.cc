#include <cstdio>

class MaxHeap{
public:
    int pop();
    void push(int newData);
    void printHeap();
private:
    int data[100000];
    int size = 0;
    void swap(int i1, int i2);
};

void MaxHeap::swap(int i1, int i2){
    int temp;
    temp = data[i1];
    data[i1] = data[i2];
    data[i2] = temp;
}

void MaxHeap::printHeap(){
    printf("Heap Data : ");
    for(int i = 0; i < size; i++){
        printf("%d ", data[i]);
    }
    printf("\n");
}

int MaxHeap::pop(){
    int ind = 0, result = 0, L, R;

    if(size){
        result = data[0];
        data[0] = data[--size];
        while(ind < size){
            L = ind*2+1;
            R = ind*2+2;
            if(L >= size)
                break;
            else if(R >= size){
                if(data[ind] < data[L]){
                    swap(ind, L);
                    ind = L;
                } else
                    break;
            } else{
                int larger = data[L] > data[R] ? L : R;
                if(data[ind] < data[larger]){
                    swap(ind, larger);
                    ind = larger;
                } else
                    break;
            }
        }
    }
    //printHeap();
    return result;
}

void MaxHeap::push(int newData){
    int ind = size, parent, temp;
    data[ind] = newData;
    parent = (ind - 1) / 2;

    while(ind >= 0 && data[ind] > data[parent]){
        swap(ind, parent);
        ind = parent;
        parent = (ind - 1) / 2;
    }
    size++;
    //printHeap();
}

int main(){
    int N, X;
    MaxHeap heap;

    scanf("%d", &N);
    for(int i = 0; i < N; i++){
        scanf("%d", &X);
        if(X){
            heap.push(X);
        } else{
            printf("%d\n", heap.pop());
        }
    }

    return 0;
}