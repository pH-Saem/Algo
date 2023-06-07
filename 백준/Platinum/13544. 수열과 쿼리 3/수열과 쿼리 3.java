import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer st;

    static int N, M, size;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        init();
        solution();
    }

    static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        size = 1;
        while (size < N) {
            size *= 2;
        }
        tree = new List[size * 2];

        for (int i = 0; i < size * 2; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int num;
        for (int i = 1; i <= N; i++) {
            num = Integer.parseInt(st.nextToken());
            update(1, 1, size, i, num);
        }

        for (int i = 0; i < size * 2; i++) {
            Collections.sort(tree[i]);
        }
    }

    static void solution() throws IOException {
        M = Integer.parseInt(br.readLine());

        int i, j, k, ans = 0;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken()) ^ ans;
            j = Integer.parseInt(st.nextToken()) ^ ans;
            k = Integer.parseInt(st.nextToken()) ^ ans;

            ans = getBigger(1, 1, size, i, j, k);
            output.append(ans).append("\n");
        }

        System.out.println(output);
    }

    static int binarySearch(int target, List<Integer> list) {
        int left = 0, right = list.size(), mid;

        while (left < right) {
            mid = (left + right) / 2;

            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    static void update(int cur, int left, int right, int target, int value) {
        if (target < left || right < target) return;
        tree[cur].add(value);
        if (left != right) {
            update(cur * 2, left, (left + right) / 2, target, value);
            update(cur * 2 + 1, (left + right) / 2 + 1, right, target, value);
        }
    }

    static int getBigger(int cur, int left, int right, int targetLeft, int targetRight, int target) {
        if (targetLeft > right || targetRight < left) {
            return 0;
        }
        if (targetLeft <= left && right <= targetRight) {
            return tree[cur].size() - binarySearch(target, tree[cur]);
        }
        return getBigger(cur * 2, left, (left + right) / 2, targetLeft, targetRight, target) +
                getBigger(cur * 2 + 1, (left + right) / 2 + 1, right, targetLeft, targetRight, target);
    }
}