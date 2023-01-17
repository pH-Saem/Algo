#include <stdio.h>
#include <malloc.h>
typedef struct St_input
{
	char alp;
	struct St_input* next;
}S_input;
void AddChar(S_input**, S_input**, char);

int main()
{
	S_input *head = NULL, *tail = NULL, *p = NULL;
	char temp = 0;
	int max[3] = { 0, }, alp[26] = { 0, };
	while ((temp = getchar()) != '\n')
	{
		if (temp >= 'a')
			temp = temp - 'a' + 'A';
		AddChar(&head, &tail, temp);
	}
	p = head;
	while (NULL != p)
	{
		temp = p->alp - 'A';
		alp[temp]++;
		p = p->next;
	}	
	while (NULL != head)
	{
		p = head;
		head = head->next;
		free(p);
	}
	for (int i = 0; i < 26; i++)
	{
		if (alp[i] > max[0])
		{
			max[0] = alp[i];
			max[1] = 0;
			max[2] = i;
		}
		else if (alp[i] == max[0])
			max[1] = alp[i];
	}
	if (max[1])
		printf("?");
	else
		printf("%c", 'A' + max[2]);

	return 0;
}

void AddChar(S_input** head, S_input** tail, char data)
{
	if (NULL != *head)
	{
		(*tail)->next = (S_input*)malloc(sizeof(S_input));
		*tail = (*tail)->next;
	}
	else
	{
		*head = (S_input*)malloc(sizeof(S_input));
		*tail = *head;
	}
	(*tail)->alp = data;
	(*tail)->next = NULL;
}