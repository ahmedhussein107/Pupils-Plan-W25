#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int t;
    cin >> t;

    while (t--)
    {
        string s;
        cin >> s;

        // If the size is greater than 10,
        // print the first character, the last character,
        // and then the size (minus the two characters).
        if (s.size() > 10)
            cout << s[0] << s.size() - 2 << s[s.size() - 1] << endl;
        else
            cout << s << endl;
    }

    return 0;
}
