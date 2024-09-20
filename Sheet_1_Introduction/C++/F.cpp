#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int n;
    cin >> n;

    string s;
    cin >> s;

    int count{};

    for (int i = 0; i < n - 1; ++i) {
        // If the current character is equal to the next character,
        // increment the count.
        if (s[i] == s[i + 1])
        {
            count++;
        }
    }

    cout << count << endl;

    return 0;
}
