//      ﷽

#include <bits/stdc++.h>

using namespace std;

// 48-57 -> 0-9  65-90 -> A-Z 97-122 -> a-z
#define Wl3_ElNor       ios::sync_with_stdio(0),cin.tie(0),cout.tie(0);
#define int             long long
#define all(vec)        vec.begin(), vec.end()
#define rall(vec)       vec.rbegin(), vec.rend()
#define ef              else if
#define retv(x)         return void(cout << (x) << '\n')
#define sp              " "
#define SetPre(n, x)    cout << fixed << setprecision(n) << x << '\n'
#define sz(s)           (int)(s).size()
#define ceil(n, m)      (((n) + (m) - 1) / (m))
#define add_mod(a, b, m) (((a % m) + (b % m)) % m)
#define sub_mod(a, b, m) (((a % m) - (b % m) + m) % m)
#define mul_mod(a, b, m) (((a % m) * (b % m)) % m)
constexpr int INF = 1 << 30, Mod = 1e9 + 7;
constexpr int LINF = 1LL << 62;


constexpr int dx[] = {0, 0, 1, -1};
constexpr int dy[] = {1, -1, 0, 0};
// constexpr char di[] = {'R', 'L', 'D', 'U'};
// const int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
// const int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
// const int N = 2e5 + 5;


void Eft7_Elkahraba(int testcase) {
    int n, m;
    cin >> n >> m;

    bool grid[n][m];
    memset(grid, false, sizeof grid);

    int k;
    cin >> k;

    if (k >= n * m) {
        cout << "1 1";
        return;
    }

    queue<pair<int, int>> q;

    for (int i = 0, x, y; i < k; ++i) {
        cin >> x >> y;
        x--, y--;
        grid[x][y] = true;
        q.emplace(x, y);
    }

    pair<int, int> lst = {0, 0};
    while (!q.empty()) {
        auto [x, y] = q.front();
        q.pop();

        lst.first = x + 1, lst.second = y + 1;

        for (int d = 0; d < 4; ++d) {
            int nx = dx[d] + x;
            int ny = dy[d] + y;

            if (nx >= 0 and nx < n and ny >= 0 and ny < m and !grid[nx][ny]) {
                q.emplace(nx, ny);
                grid[nx][ny] = true;
            }
        }
    }

    cout << lst.first << sp << lst.second << '\n';
}

signed main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    Wl3_ElNor
    int T = 1;
    // cin >> T;
    for (int testcase = 1; testcase <= T; ++testcase) {
          // cout << "Case #" << testcase << ": ";
          Eft7_Elkahraba(testcase);
    }

    return 0;
}