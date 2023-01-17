#include <cstdio>

int min_heap[100001];
int p = 1;

void swap(int ind1, int ind2);
void push(int x);
int pop();

int main()
{
	int N, input;

	scanf("%d", &N);
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &input);
		if (input == 0)
			printf("%d\n", pop());
		else if (input > 0)
			push(input);
	}

	return 0;
}

void swap(int ind1, int ind2)
{
	int temp;
	temp = min_heap[ind1];
	min_heap[ind1] = min_heap[ind2];
	min_heap[ind2] = temp;
}

void push(int x)
{
	int parent_ind, insert_ind = p;
	parent_ind = insert_ind / 2;
	min_heap[insert_ind] = x;

	if (p == 1)
		min_heap[insert_ind] = x;
	else
	{
		while (1)
		{
			if (min_heap[insert_ind] >= min_heap[parent_ind])
				break;
			else
			{
				swap(insert_ind, parent_ind);
				insert_ind = parent_ind;
				parent_ind = insert_ind / 2;
			}
		}
	}
	p++;
}

int pop()
{
	int min;
	int current_ind, smaller_child;
	int left_child, right_child;
	if (p == 1)
		min = 0;
	else
	{
		p--;
		min = min_heap[1];
		min_heap[1] = min_heap[p];

		current_ind = 1;
		while (1)
		{
			left_child = current_ind * 2;
			right_child = left_child + 1;
			if (left_child <= p)
			{
				if (right_child <= p)
				{
					if (min_heap[left_child] < min_heap[right_child])
						smaller_child = left_child;
					else
						smaller_child = right_child;
				}
				else
					smaller_child = left_child;

				if (min_heap[current_ind] > min_heap[smaller_child])
				{
					swap(current_ind, smaller_child);
					current_ind = smaller_child;
				}
				else
					break;
			}
			else
				break;
		}
	}
	return min;
}
