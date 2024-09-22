#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int t;
    cin >> t;

    while (t--)
    {
        char arr[8][8];

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                cin >> arr[i][j];
            }
        }

        bool flag;

        for (int i = 0; i < 8; ++i) {
            flag = true;

            for (int j = 0; j < 8; ++j) {
                if (arr[i][j] == 'B')
                {
                    flag = false;
                    break;
                }
            }

            // After checking the row, if there isn't any 'B's then break.
            if (flag)
                break;
        }

        // If true, then we have found a row containing all 'R's.
        // Otherwise, there is a column that contains all 'B's.
        if (flag)
            cout << "R" << endl;
        else
            cout << "B" << endl;
    }

    return 0;
}
