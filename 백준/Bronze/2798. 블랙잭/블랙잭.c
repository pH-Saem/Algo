#include <stdio.h>
#include <malloc.h>

int main(){
	int N, M, data[100] = { 0, }, blackjack = 0, temp = 0;
	scanf("%d %d", &N, &M);
	for (int i = 0; i < N; i++) 
		scanf("%d", &data[i]);
	
	for(int i = 0; i < N - 2; i++)
		for(int j = i+1; j < N - 1; j++)
			for (int k = j+1; k < N; k++) {
				temp = data[i] + data[j] + data[k];
				if (temp > M)
					continue;
				else if (temp > blackjack) 
					blackjack = temp;				
			}
	printf("%d", blackjack);
	return 0;
}