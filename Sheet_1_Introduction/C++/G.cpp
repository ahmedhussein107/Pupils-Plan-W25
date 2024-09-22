#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int y;
    cin >> y;

    while (true)
    {
        y++;

        int a, b, c, d;
        a = y % 10;
        b = (y / 10) % 10;
        c = (y / 100) % 10;
        d = (y / 1000) % 10;

        // Check that all the digits are distinct.
        if (a != b && a != c && a != d &&
            b != c && b != d && c != d)
        {
            cout << y << endl;
            break;
        }
    }

    return 0;
}
