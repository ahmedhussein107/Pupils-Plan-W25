#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;

    int count{};

    while (n--)
    {
        int a, b, c;
        cin >> a >> b >> c;

        // Take the three values and sum them.
        int sum = a + b + c;

        // If their sum is greater than 2,
        // increment the count of solvable problems.
        if (sum >= 2)
            count++;
    }

    cout << count << endl;

    return 0;
}
