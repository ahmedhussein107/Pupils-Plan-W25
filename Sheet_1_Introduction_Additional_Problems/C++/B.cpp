#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int t;
    cin >> t;

    int row = 8;
    int col = 8;

    while (t--)
    {
        char arr[row][col];

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                cin >> arr[i][j];
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                // Check if the corners of a '#' are also a '#'.
                // Such case means we are at the bishop.
                if (arr[i][j] == '#' && arr[i - 1][j - 1] == '#' && arr[i - 1][j + 1] == '#'
                && arr[i + 1][j - 1] == '#' && arr[i + 1][j + 1] == '#')
                {
                    cout << i + 1 << " " << j + 1 << endl;
                }
            }
        }
    }

    return 0;
}
