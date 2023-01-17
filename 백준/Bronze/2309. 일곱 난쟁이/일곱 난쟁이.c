#include <stdio.h>

void find7(int data[], int sum);
void quickSort(int data[], int st, int en);

int main() {
	int data[9], sum = 0;
	for (int i = 0; i < 9; i++) {
		scanf("%d", &data[i]);
		sum += data[i];
	}
	quickSort(data, 0, 8);
	find7(data, sum);
}

void quickSort(int data[], int st, int en) {
	int p = data[en], temp;	// 데이터의 마지막 값을 기준으로 잡고 p에 저장하였다.
	int m = st;					// p가 들어갈 위치를 저장할 변수
	if (st < en) {
		for (int i = st; i < en; i++) {
			if (data[i] <= p) {
				temp = data[i];
				data[i] = data[m];
				data[m] = temp;
				m++;
			}
		}
		for (int i = en; i > m; i--)
			data[i] = data[i - 1];
		data[m] = p;
		quickSort(data, st, m - 1);
		quickSort(data, m + 1, en);
	}
}


void find7(int data[], int sum) {
	int i, j, temp;

	for (i = 0; i < 9; i++) {
		for (j = i+1; j < 9; j++) {
			temp = sum - data[i] - data[j];
			if (temp == 100)
				break;
		}
		if (temp == 100)
			break;
	}

	for (temp = 0; temp < 9; temp++) {
		if (temp != i && temp != j)
			printf("%d\n", data[temp]);
	}
}