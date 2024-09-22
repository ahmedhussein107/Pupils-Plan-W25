#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;

    int arr[n + 1];

    // The x's index received a gift from ith person.
    // e.g. arr[2] = 1 means the first person gave a gift to the second one.
    for (int i = 1; i <= n; ++i) {
        int x;
        cin >> x;

        arr[x] = i;
    }

    // Print the givers.
    for (int i = 1; i <= n; ++i) {
        cout << arr[i] << " ";
    }

    cout << endl;

    return 0;
}
