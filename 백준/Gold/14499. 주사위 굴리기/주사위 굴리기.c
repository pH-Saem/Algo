#include <stdio.h>
#include <malloc.h>

int M, N, x, y, k;
int sides[5] = { 1,4,3,5,2 };
int dice[7] = { 0, };

int move_dice(int move)
{
	int f_x = x, f_y = y;
	if (move == 1)
		y++;
	else if (move == 2)
		y--;
	else if (move == 3)
		x--;
	else if (move == 4)
		x++;

	if (x < 0 || y < 0 || x >= N || y >= M)
	{
		x = f_x;
		y = f_y;
		return -1;
	}
	else
		return x * M + y;	
}

void change_sides(int move)
{
	if (move == 1)
	{
		sides[2] = sides[0];
		sides[0] = sides[1];
		sides[1] = 7 - sides[2];

	}
	else if (move == 2)
	{
		sides[1] = sides[0];
		sides[0] = sides[2];
		sides[2] = 7 - sides[1];

	}
	else if (move == 3)
	{
		sides[4] = sides[0];
		sides[0] = sides[3];
		sides[3] = 7 - sides[4];
	}
	else if (move == 4)
	{
		sides[3] = sides[0];
		sides[0] = sides[4];
		sides[4] = 7 - sides[3];
	}
}

void change_zero(int *map, int bottom, int pos)
{
	if (map[pos] == 0)
		map[pos] = dice[bottom];
	else
	{
		dice[bottom] = map[pos];
		map[pos] = 0;
	}
}

int main()
{
	int* map, *moves, move, bottom, pos;
	
	scanf("%d %d %d %d %d", &N, &M, &x, &y, &k);

	map = (int*)malloc(sizeof(int) * M * N);
	moves = (int*)malloc(sizeof(int) * k);

	for (int i = 0; i < N; i++)
		for (int j = 0; j < M; j++)
			scanf("%d", &map[i * M + j]);
	
	for (int i = 0; i < k; i++)
		scanf("%d", &moves[i]);
	

	for (int i = 0; i < k; i++)
	{
		move = moves[i];
		pos = move_dice(move);

		if (pos != -1)
		{
			printf("%d\n", dice[sides[move]]);
			
			change_sides(move);

			bottom = 7 - sides[0];
			change_zero(map, bottom, pos);
		}

	}

	free(map);
	free(moves);

	return 0;
}