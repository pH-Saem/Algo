#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>

typedef struct _meeting{
	int start;
	int end;
}meeting;

int compare(const void *a, const void *b)
{
	meeting m1 = *(meeting *)a;
	meeting m2 = *(meeting *)b;

	if(m1.end > m2.end)
		return 1;
	if(m1.end < m2.end)
		return -1;
	// 같으면 start가 작은게 위로
	if(m1.start > m2.start)
		return 1;
	if(m1.start < m2.start)
		return -1;
	return 0;
}

int main() {
	int N, clock = 0, cnt = 0;
	meeting* table;

	scanf("%d", &N);

	table = (meeting*)malloc(N * sizeof(meeting));
	for (int i = 0; i < N; i++)
		scanf("%d %d", &table[i].start, &table[i].end);

	// 끝나는 시간 기준으로 오름차순 정렬
	qsort(table, N, sizeof(meeting), compare);
	
	// 끝나는 시간이 가장 빠르고 현재 시간보다 시작시간이 작거나 같으면
	// 회의 진행 및 끝나는 시간으로 현재 시간 설정
	for (int i = 0; i < N; i++) {
		if (clock <= table[i].start) {
			clock = table[i].end;
			cnt++;
		}
	}
	
	printf("%d", cnt);
	free(table);
	return 0;
}