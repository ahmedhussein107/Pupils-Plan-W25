#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;

    int count[5] = { };

    for (int i = 0; i < n; ++i) {
        int x;
        cin >> x;

        count[x]++;
    }

    int result = count[4] + count[3] + ceil(count[2] / 2);

    count[1] = max(0, count[1] - count[3]);

    if (count[2] % 2 == 1)
    {
        result++;
        count[1] = max(0, count[1] - 2);
    }

    result += ceil((count[1] + 3) / 4);
    cout << result << endl;

    return 0;
}
