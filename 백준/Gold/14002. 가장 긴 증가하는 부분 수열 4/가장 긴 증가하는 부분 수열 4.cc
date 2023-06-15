#include <cstdio>
#include <vector>
#include <algorithm>
#include <stack>

using namespace std;

int N;
int* arr;

void init() {
	scanf("%d", &N);

	arr = new int[N];
	for (int i = 0; i < N; i++) {
		scanf("%d", &arr[i]);
	}
}

void solution() {
	int index;
	int* prevPath = new int[N];
	vector<int> subArr, indArr;

	for (int i = 0; i < N; i++) {
		index = lower_bound(subArr.begin(), subArr.end(), arr[i]) - subArr.begin();
		
		if (index == subArr.size()) {
			subArr.push_back(arr[i]);
			indArr.push_back(i);
		}
		else {
			subArr[index] = arr[i];
			indArr[index] = i;
		}

		if (index == 0) 
			prevPath[i] = -1;
		else 
			prevPath[i] = indArr[index - 1];
		
	}

	printf("%d\n", subArr.size());

	stack<int> stack;
	stack.push(arr[indArr.back()]);
	index = prevPath[indArr.back()];
	while (index != -1) {
		stack.push(arr[index]);
		index = prevPath[index];
	}

	while (!stack.empty()) {
		printf("%d ", stack.top());
		stack.pop();
	}

	delete[] prevPath;
}

int main() {
	init();
	solution();
	return 0;
}