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


// constexpr int dx[] = {0, 0, 1, -1};
// constexpr int dy[] = {1, -1, 0, 0};
// constexpr char di[] = {'R', 'L', 'D', 'U'};
// const int dx[] = {0, 1, 1, 1, 0, -1, -1, -1};
// const int dy[] = {1, 1, 0, -1, -1, -1, 0, 1};
const int N = 105;


int n, m;
vector<vector<pair<int, int>>> adj(N);
bool vis[N];

bool dfs(int node, int target, int color) {
    if (node == target) return true;
    vis[node] = true;

    for (auto [neighbour, curColor] : adj[node]) {

        if (vis[neighbour] or color != curColor) continue;

        if (dfs(neighbour, target, color)) {
            return true;
        }

    }
    return false;
}

void Eft7_Elkahraba(int testcase) {
    cin >> n >> m;
    for(int i = 0, u, v, c; i < m; ++i) {
        cin >> u >> v >> c;
        adj[u].push_back({v, c});
        adj[v].push_back({u, c});
    }
    int q;
    cin >> q;

    while (q--) {
        int u, v;
        cin >> u >> v;

        int ans = 0;
        for (int c = 1; c <= 100; ++c) {
            memset(vis, false, sizeof vis);
            ans += dfs(u, v, c);
        }
        cout << ans << '\n';
    }
}

signed main() {
    // freopen("input.txt", "r", stdin);
    // freopen("output.txt", "w", stdout);
    Wl3_ElNor
    int T = 1;
    // cin >> T;
    for (int testcase = 1; testcase <= T; ++testcase) {
          // cout << "Case #" << testcase << ": ";
          Eft7_Elkahraba(testcase);
    }

    return 0;
}