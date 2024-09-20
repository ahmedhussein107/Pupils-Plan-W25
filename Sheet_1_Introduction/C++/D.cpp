#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;

    long long sum{};
    int minimumOdd = INT_MAX;

    while (n--)
    {
        int x;
        cin >> x;

        // Find the smallest odd number.
        if (x % 2 == 1)
        {
            minimumOdd = min(minimumOdd, x);
        }

        sum += x;
    }

    // If the final sum is odd, subtract from it the smallest odd.
    // Reason is because odd - odd will always result in even.
    if (sum % 2 == 1)
        sum -= minimumOdd;

    cout << sum << endl;

    return 0;
}
