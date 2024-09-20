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

        // If the string size is odd, print "NO".
        if (s.size() % 2 == 1)
        {
            cout << "NO" << endl;
            continue;
        }

        bool flag = true;

        int middle = s.size() / 2;

        // Find the middle and compare it to the first character.
        // As you continue incrementing, also increment the other side.
        for (int i = 0; i < middle; ++i) {
            if (s[i] != s[i + middle])
            {
                flag = false;
                break;
            }
        }

        cout << (flag ? "YES" : "NO") << endl;
    }

    return 0;
}
