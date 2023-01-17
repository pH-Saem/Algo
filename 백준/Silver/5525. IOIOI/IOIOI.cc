#include <cstdio>
#include <cstring>

int N, M, count;
char S[1000001];
char P[2000002];

int main() {
    scanf("%d %d %s", &N, &M, S);
    for (int i = 0; i < N; i++) {
        P[2 * i] = 'I';
        P[2 * i + 1] = 'O';
    }
    P[2 * N] = 'I';

    char* p = strstr(S, P);
    while (p != NULL) {
        count++;
        p = strstr(p + 1, P);
    }

    printf("%d\n", count);

    return 0;
}