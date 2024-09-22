#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;

    // Iterate till n - 1.
    for (int i = 1; i < n; ++i) {
        if (i % 2 == 0)
        {
            cout << "I love that ";
        }
        else if (i % 2 != 0)
        {
            cout << "I hate that ";
        }
    }

    // If the input number is even, then end with love 'it'.
    // Otherwise, end with hate 'it'.
    if (n % 2 == 0)
        cout << "I love it" << endl;
    else
        cout << "I hate it" << endl;

    return 0;
}
